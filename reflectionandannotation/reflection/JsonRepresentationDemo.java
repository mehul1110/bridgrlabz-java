package reflectionandannotation.reflection;

import java.lang.reflect.Field;

/**
 * Demonstrates generating a JSON-like representation of an object using
 * Reflection.
 */
class User {
    private String username;
    private int id;
    private boolean active;

    public User(String username, int id, boolean active) {
        this.username = username;
        this.id = id;
        this.active = active;
    }
}

public class JsonRepresentationDemo {

    /**
     * Converts an object into a JSON formatted string dynamically using reflection.
     */
    public static String toJson(Object obj) {
        if (obj == null)
            return "null";

        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{\n");
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                String name = field.getName();
                Object value = field.get(obj);

                // Start appending field name key
                json.append("  \"").append(name).append("\": ");

                // Add string wrapper quote character conditionally
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                // Append comma if it's not the last element
                if (i < fields.length - 1) {
                    json.append(",");
                }
                json.append("\n");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        User user = new User("admin_User", 999, true);
        System.out.println("Generated JSON Representation:\n" + toJson(user));
    }
}
