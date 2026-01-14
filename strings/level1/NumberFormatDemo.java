import java.util.Scanner;

public class NumberFormatDemo {
    public static int generateException(String text) {
        return Integer.parseInt(text);
    }

    public static void handleException(String text) {
        try {
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException ex) {
            System.out.println("Caught NumberFormatException: invalid integer");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text to parse as int: ");
            String text = sc.nextLine();
            try {
                int v = generateException(text);
                System.out.println("Parsed value: " + v);
            } catch (NumberFormatException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            handleException(text);
        }
    }
}
