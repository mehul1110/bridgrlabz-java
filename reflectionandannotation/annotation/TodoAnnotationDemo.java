package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Practice Problem 2: Create a @Todo Annotation for Pending Tasks
 */

// Step 1: Definition of the custom runtime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();

    String assignedTo();

    String priority() default "MEDIUM";
}

// Step 2: Decorating methods within a business logic class
class ApplicationInitializer {

    // Applying the Custom @Todo Annotation with specified assignment
    @Todo(task = "Implement JWT-based authentication", assignedTo = "Alice Johnson", priority = "HIGH")
    public void setupSecurity() {
        System.out.println("Configuring Security (Pending Implementation...)");
    }

    // Relying on default Priority of "MEDIUM"
    @Todo(task = "Migrate database schema to PostgreSQL", assignedTo = "Bob Smith")
    public void configureDatabase() {
        System.out.println("Configuring Database (Pending Implementation...)");
    }

    public void setupUI() {
        System.out.println("Setting up User Interface elements.");
    }
}

public class TodoAnnotationDemo {
    public static void main(String[] args) {
        System.out.println("--- Pending Tasks Analysis based on @Todo Annotation ---\n");

        Class<?> clazz = ApplicationInitializer.class;

        System.out.println("Scanning Project for open @Todo tickets...\n");

        // Loop through all methods belonging to the `ApplicationInitializer` class
        // definition
        for (Method method : clazz.getDeclaredMethods()) {

            // Verifying the presence of @Todo metadata on specific methods
            if (method.isAnnotationPresent(Todo.class)) {

                // Fetch details of annotation via Reflection
                Todo todoProperties = method.getAnnotation(Todo.class);

                System.out.println("[TASK TICKET] Related Method: '" + method.getName() + "()'");
                System.out.println("   Description : " + todoProperties.task());
                System.out.println("   Assignee    : " + todoProperties.assignedTo());
                System.out.println("   Priority    : " + todoProperties.priority() + "\n");
            }
        }
    }
}
