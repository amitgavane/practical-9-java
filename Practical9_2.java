public class Practical9_2 {

    public static void main(String[] args) {
        if (args.length > 0) {
            int size = Integer.parseInt(args[0]);
            char[] letters = new char[size];

            System.out.print("Generated Characters: ");
            for (int i = 0; i < size; i++) {
                char letter = (char) ((System.nanoTime() % 26) + 65);
                letters[i] = letter;
                System.out.print(letters[i] + " ");
            }
            System.out.println("\n");

            String normalText = "text";
            StringBuffer textBuffer = new StringBuffer("text");
            StringBuilder textBuilder = new StringBuilder("text");

            long timeNormalText = 0;
            long timeTextBuffer = 0;
            long timeTextBuilder = 0;

            for (int i = 0; i < size; i++) {
                long start = System.nanoTime();
                normalText += letters[i];
                long end = System.nanoTime();
                timeNormalText += (end - start);

                start = System.nanoTime();
                textBuffer.append(letters[i]);
                end = System.nanoTime();
                timeTextBuffer += (end - start);

                start = System.nanoTime();
                textBuilder.append(letters[i]);
                end = System.nanoTime();
                timeTextBuffer += (end - start);
            }

            System.out.println("Average Time for String: " + timeNormalText / args.length + " ns");
            System.out.println("Average Time for StringBuffer: " + timeTextBuffer / args.length + " ns");
            System.out.println("Average Time for StringBuilder: " + timeTextBuilder / args.length + " ns\n");

            if (timeNormalText < timeTextBuffer && timeNormalText < timeTextBuilder) {
                System.out.println("String is the fastest.");
            } else if (timeTextBuffer < timeNormalText && timeTextBuffer < timeTextBuilder) {
                System.out.println("StringBuffer is the fastest.");
            } else if (timeTextBuilder < timeNormalText && timeTextBuilder < timeTextBuffer) {
                System.out.println("StringBuilder is the fastest.");
            } else {
                System.out.println("All methods perform similarly.");
            }
        }
    }
}
