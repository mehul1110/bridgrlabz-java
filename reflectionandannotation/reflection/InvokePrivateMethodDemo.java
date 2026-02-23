package reflectionandannotation.reflection;

import java.lang.reflect.Method;

/**
 * Demonstrates invoking a private method using Reflection.
 */
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethodDemo {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Class<?> clazz = calculator.getClass();

            // Get the private method 'multiply' that takes two int parameters
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);

            // Allow access to the private method
            multiplyMethod.setAccessible(true);

            // Invoke the method dynamically
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            System.out.println("Result of private method multiply(5, 10): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
