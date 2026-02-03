package exceptions;

/**
 * Practice Problem 8: Exception Propagation
 * 
 * Problem: method1 -> method2 -> main.
 * Expected: "Handled exception in main".
 */
public class ExceptionPropagationDemo {

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void method2() {
        method1();
    }

    public static void method1() {
        int result = 10 / 0;
    }
}
