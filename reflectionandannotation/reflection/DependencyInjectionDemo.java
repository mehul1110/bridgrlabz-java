package reflectionandannotation.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Demonstrates a simple Dependency Injection container using Reflection.
 */

// Custom @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

// Service class
class DatabaseService {
    public void connect() {
        System.out.println("Connecting to Database Service.");
    }
}

// Client class that depends on the service
class ApplicationApp {

    // Inject dependency
    @Inject
    private DatabaseService databaseService;

    public void start() {
        if (databaseService != null) {
            databaseService.connect();
            System.out.println("Application App Started!");
        } else {
            System.out.println("Error: Dependency DatabaseService is missing!");
        }
    }
}

// Simple Dependency Injection framework via Reflection
class DIContainer {
    public static void performDependencyInjection(Object target) throws Exception {
        Class<?> clazz = target.getClass();

        // Scan all fields inside the target class
        for (Field field : clazz.getDeclaredFields()) {
            // Check if the current field is annotated with @Inject
            if (field.isAnnotationPresent(Inject.class)) {
                // Ignore private modifiers
                field.setAccessible(true);

                // Dynamically instantiate object via target field type's default constructor
                Object dependency = field.getType().getDeclaredConstructor().newInstance();

                // Inject dynamically
                field.set(target, dependency);
                System.out.println("[DI System] Injected component '" + field.getType().getSimpleName() + "' into '"
                        + clazz.getSimpleName() + "'");
            }
        }
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        try {
            ApplicationApp clientClient = new ApplicationApp();

            // Status before resolving DI
            System.out.println("--- Before Invoking DI ---");
            clientClient.start();

            // Run DI resolution
            DIContainer.performDependencyInjection(clientClient);

            // Access Service after wiring up DI
            System.out.println("\n--- After Wiring up via DI ---");
            clientClient.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
