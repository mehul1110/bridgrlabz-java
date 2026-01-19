/*
 * This program performs division and modulus
 * operations to distribute items equally
 */
public class PenDistributionCalculator {

    public static void main(String[] args) {

        // Define total items and total count for division
        int pens = 14;
        int students = 3;

        // Calculate equal distribution using division
        int perStudent = pens / students;

        // Find the remainder using modulus operation
        int remaining = pens % students;

        // Display the distribution result
        System.out.println(
                "The Pen Per Student is " + perStudent +
                        " and the remaining pen not distributed is " + remaining
        );
    }
}
