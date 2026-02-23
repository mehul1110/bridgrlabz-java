package reflectionandannotation.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Demonstrates dynamically invoking methods in a class based on user input.
 */
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available methods in MathOperations: add, subtract, multiply");
        System.out.print("Enter method name to invoke: ");
        String methodName = scanner.nextLine();

        try {
            MathOperations mathOps = new MathOperations();
            Class<?> clazz = mathOps.getClass();

            // Retrieve method dynamically by name and parameter types
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Dynamically invoke the method with sample arguments
            int result = (int) method.invoke(mathOps, 20, 10);

            System.out.println("Result of calling " + methodName + "(20, 10): " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Method '" + methodName + "' not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
