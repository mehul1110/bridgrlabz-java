package stacksandhash.stacksandqueues;

/**
 * CircularTour - Petrol pump tour starting point finder.
 * Simulation: Displays fuel balance and cumulative deficit at each pump.
 */
public class CircularTour {

    private static class PetrolPump {
        int petrol, distance;

        PetrolPump(int p, int d) {
            this.petrol = p;
            this.distance = d;
        }
    }

    public int findStartingPoint(PetrolPump[] pumps) {
        int start = 0;
        int deficit = 0;
        int balance = 0;

        System.out.println("Processing Circular Tour Path...");
        System.out.println("--------------------------------");

        for (int i = 0; i < pumps.length; i++) {
            int currentDiff = pumps[i].petrol - pumps[i].distance;
            balance += currentDiff;

            System.out.print(
                    "Pump " + i + " [P:" + pumps[i].petrol + ", D:" + pumps[i].distance + "] | Balance: " + balance);

            if (balance < 0) {
                deficit += balance;
                System.out.println(" -> Underflow! Resetting start to " + (i + 1));
                start = i + 1;
                balance = 0;
            } else {
                System.out.println(" -> OK");
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Final Check: Surplus(" + balance + ") + Deficit(" + deficit + ") = " + (balance + deficit));
        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Circular Tour Simulation ===");
        CircularTour ct = new CircularTour();
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };
        int result = ct.findStartingPoint(pumps);
        if (result != -1)
            System.out.println("Solution: Possible starting index is " + result);
        else
            System.out.println("Solution: No circular tour possible.");
    }
}
