import java.util.Scanner;

public class IllegalArgumentDemo {
    public static String generateException(String s, int st, int en) {
        // explicitly throw IllegalArgumentException when start > end as per exercise
        if (st > en) throw new IllegalArgumentException("Start index greater than end index");
        // may still throw StringIndexOutOfBoundsException if indices outside bounds
        return s.substring(st, en);
    }

    public static void handleException(String s, int st, int en) {
        try {
            System.out.println(s.substring(st, en));
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught IllegalArgumentException: " + ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Caught IndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: "); String s = sc.nextLine();
            System.out.print("Enter start index: "); int st = sc.nextInt();
            System.out.print("Enter end index: "); int en = sc.nextInt();
            try {
                String result = generateException(s, st, en);
                System.out.println(result);
            } catch (IllegalArgumentException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            handleException(s, st, en);
        }
    }
}
