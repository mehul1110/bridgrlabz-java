package searching;

/**
 * Problem: Compare performance of StringBuffer and StringBuilder for 1 million
 * concatenations.
 */
public class CompareStringBuilders {
    public static void main(String[] args) {
        int iterations = 1000000;
        String textToAppend = "hello";

        // Performance test for StringBuilder
        long startTimeSB = System.nanoTime();
        StringBuilder stBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stBuilder.append(textToAppend);
        }
        long endTimeSB = System.nanoTime();
        long durationSB = endTimeSB - startTimeSB;

        // Performance test for StringBuffer
        long startTimeSBuf = System.nanoTime();
        StringBuffer stBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stBuffer.append(textToAppend);
        }
        long endTimeSBuf = System.nanoTime();
        long durationSBuf = endTimeSBuf - startTimeSBuf;

        System.out.println("Iterations: " + iterations);
        System.out
                .println("Time taken by StringBuilder: " + durationSB + " ns (" + (durationSB / 1_000_000.0) + " ms)");
        System.out.println(
                "Time taken by StringBuffer:  " + durationSBuf + " ns (" + (durationSBuf / 1_000_000.0) + " ms)");

        if (durationSB < durationSBuf) {
            System.out.println("StringBuilder was faster by " + ((durationSBuf - durationSB) / 1_000_000.0) + " ms");
        } else {
            System.out.println("StringBuffer was faster or equal.");
        }
    }
}
