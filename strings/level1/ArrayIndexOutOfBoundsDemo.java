import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] arr) {
        // access invalid index
        System.out.println(arr[arr.length]);
    }

    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many names? ");
            int n = sc.nextInt();
            sc.nextLine();
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter name " + (i+1) + ": ");
                names[i] = sc.nextLine();
            }
            try {
                generateException(names);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            handleException(names);
        }
    }
}
