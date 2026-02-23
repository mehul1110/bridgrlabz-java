package reflectionandannotation.reflection;

import java.lang.reflect.Field;

/**
 * Demonstrates accessing and modifying a private field using Reflection.
 */
class Person {
    private int age = 25;
}

public class AccessPrivateFieldDemo {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            Class<?> clazz = person.getClass();

            // Get the private declared field 'age'
            Field ageField = clazz.getDeclaredField("age");
            
            // Allow access to private field
            ageField.setAccessible(true);

            // Retrieve old value
            System.out.println("Original age: " + ageField.get(person));

            // Modify the value
            ageField.set(person, 30);

            // Retrieve new value
            System.out.println("Modified age: " + ageField.get(person));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
