package reflectionandannotation.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Demonstrates how to fetch Class info using Reflection based on user input.
 */
public class ClassInfoDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter full class name (e.g., java.lang.String, java.util.ArrayList, java.util.Scanner)");
        System.out.print("Class Name: ");
        String className = scanner.nextLine();

        try {
            // Load the class based on input
            Class<?> clazz = Class.forName(className);

            System.out.println("Class Name: " + clazz.getName());

            // Display Fields
            System.out.println("\n--- Fields ---");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field.getType().getSimpleName() + " " + field.getName());
            }

            // Display Constructors
            System.out.println("\n--- Constructors ---");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor.toString());
            }

            // Display Methods
            System.out.println("\n--- Methods ---");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method.getReturnType().getSimpleName() + " " + method.getName() + "()");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
