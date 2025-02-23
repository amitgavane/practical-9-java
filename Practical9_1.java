public class Practical9_1 {

    public static void main(String[] args) {
        int arraySize = 0;
        if (args.length > 0) {
            arraySize = Integer.parseInt(args[0]);
        }
        int[] randomNumbers = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            randomNumbers[i] = (int) (System.nanoTime() % 101);
        }

        long totalTimeLoop = 0;
        long totalTimeRecursion = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            int currentNumber = randomNumbers[i];

            long startTime = System.nanoTime();
            long loopResult = calculateFactorialLoop(currentNumber);
            long endTime = System.nanoTime();
            totalTimeLoop += (endTime - startTime);

            startTime = System.nanoTime();
            long recursionResult = calculateFactorialRecursion(currentNumber);
            endTime = System.nanoTime();
            totalTimeRecursion += (endTime - startTime);
        }

        double averageTimeLoop = totalTimeLoop / (double) arraySize;
        double averageTimeRecursion = totalTimeRecursion / (double) arraySize;

        System.out.println("Generated Numbers: ");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Average time using Loop: " + averageTimeLoop + " ns");
        System.out.println("Average time using Recursion: " + averageTimeRecursion + " ns");

        if (averageTimeLoop < averageTimeRecursion) {
            System.out.println("Loop method is faster.");
        } else if (averageTimeLoop > averageTimeRecursion) {
            System.out.println("Recursion method is faster.");
        } else {
            System.out.println("Both methods perform equally.");
        }
    }

    public static long calculateFactorialLoop(int number) {
        long result = 1;
        for (int i = number; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static long calculateFactorialRecursion(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorialRecursion(number - 1);
    }
}
