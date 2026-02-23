package reflectionandannotation.reflection;

import java.lang.reflect.Field;

/**
 * Demonstrates how to access and modify a private static field using
 * Reflection.
 */
class Configuration {
    private static String API_KEY = "DEFAULT-API-KEY";
}

public class ModifyStaticFieldDemo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;

            // Get the private static field 'API_KEY'
            Field apiKeyField = clazz.getDeclaredField("API_KEY");

            // Allow access to the private field
            apiKeyField.setAccessible(true);

            // Retrieve the old value (use null for static fields)
            System.out.println("Original API_KEY: " + apiKeyField.get(null));

            // Modify the value
            apiKeyField.set(null, "NEW-SECRET-API-KEY-1234");

            // Retrieve and print the newly updated value
            System.out.println("Modified API_KEY: " + apiKeyField.get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
