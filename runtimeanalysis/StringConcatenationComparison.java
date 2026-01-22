package runtimeanalysis;

/**
 * 3. Problem Statement: String Concatenation Performance
 * Objective: Compare performance of String (O(N²)), StringBuilder (O(N)), and
 * StringBuffer (O(N)).
 */
public class StringConcatenationComparison {

    public static void main(String[] args) {
        int[] counts = { 1000, 10000, 100000 };

        System.out
                .println("==========================================================================================");
        System.out.println("PROBLEM 3: STRING CONCATENATION PERFORMANCE (Immutable vs Mutable)");
        System.out
                .println("==========================================================================================");
        System.out.printf("%-15s | %-15s | %-20s | %-20s\n", "Operations (N)", "String (ms)", "StringBuilder (ms)",
                "StringBuffer (ms)");
        System.out
                .println("------------------------------------------------------------------------------------------");

        // Loop through different number of operations to measure performance
        for (int n : counts) {
            // String (O(N^2)) - Because strings are immutable, each concatenation creates a
            // new object
            long startStr = System.currentTimeMillis();
            if (n <= 50000) {
                String s = "";
                // Loop to perform repeated concatenation using +=
                for (int i = 0; i < n; i++) {
                    s += "x";
                }
            }
            long endStr = System.currentTimeMillis();
            String strTime = (n > 50000) ? "Skipped (Too Slow)" : (endStr - startStr) + "ms";

            // StringBuilder (O(N)) - Mutable and fast, but not thread-safe
            long startSB = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            // Loop to perform repeated operations using append()
            for (int i = 0; i < n; i++) {
                sb.append("x");
            }
            long endSB = System.currentTimeMillis();

            // StringBuffer (O(N)) - Mutable and thread-safe (synchronized), slightly slower
            // than StringBuilder
            long startSBF = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer();
            // Loop to perform repeated operations using synchronized append()
            for (int i = 0; i < n; i++) {
                sbf.append("x");
            }
            long endSBF = System.currentTimeMillis();

            System.out.printf("%,-15d | %-15s | %-20d | %-20d\n", n, strTime, (endSB - startSB), (endSBF - startSBF));
        }
        System.out.println(
                "==========================================================================================\n");
    }
}
