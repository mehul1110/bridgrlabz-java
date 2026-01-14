import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void generateException(String s) {
        // intentionally access beyond length
        System.out.println(s.charAt(s.length()));
    }

    public static void handleException(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            try {
                generateException(s);
            } catch (StringIndexOutOfBoundsException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            handleException(s);
        }
    }
}
