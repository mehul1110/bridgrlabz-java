package reflectionandannotation.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates creating a custom object mapper to map a Map<String, Object> to
 * an object instance via Reflection.
 */
class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {
        // default constructor needed for instantiation
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class CustomObjectMapperDemo {

    /**
     * Converts a property map to an object instance of the given class.
     */
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Instantiate the class dynamically using its default constructor
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate over map entries and set matching fields via reflection
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    // Find the declared field in the target class
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    // Assign the mapped value to the dynamically created instance
                    field.set(obj, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Ignoring unmatched field: '" + fieldName + "' in " + clazz.getSimpleName());
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Define property mappings
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "John Doe");
        properties.put("age", 28);
        properties.put("salary", 55000.50); // Double value
        properties.put("department", "IT"); // Example of an unmatched field

        // Use custom object mapper to build the object entirely through reflection
        Employee emp = toObject(Employee.class, properties);
        System.out.println("Successfully Mapped Object: " + emp);
    }
}
