package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Practice Problem 1: Create an Annotation to Mark Important Methods
 */

// Step 1: Definition of the runtime Method Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Step 2: Implementation class decorating methods
class SystemProcessor {

    // Explicit assignment of priority property
    @ImportantMethod(level = "CRITICAL")
    public void configureSecurityFramework() {
        System.out.println("Executing system security configurations.");
    }

    // Default property will trigger "HIGH" priority
    @ImportantMethod
    public void initializePrimaryDatabase() {
        System.out.println("Booting up the primary database system.");
    }

    // Without any Annotation wrapper
    public void loadUserAvatars() {
        System.out.println("Loading miscellaneous user avatars.");
    }
}

public class ImportantMethodDemo {
    public static void main(String[] args) {
        System.out.println("--- Filtering Out Important Methods Based on Custom @ImportantMethod Annotation ---\n");

        Class<?> clazz = SystemProcessor.class;

        // Step 3: Loop through all methods belonging to the `SystemProcessor` Class
        // definition
        for (Method method : clazz.getDeclaredMethods()) {

            // Verifying the presence of @ImportantMethod metadata on particular methods
            if (method.isAnnotationPresent(ImportantMethod.class)) {

                // Fetch dynamic runtime priority assigned within code execution scope
                ImportantMethod annotationProperties = method.getAnnotation(ImportantMethod.class);
                System.out.println("Located flagged Method: '" + method.getName() + "()'");
                System.out.println("   Priority Level: [ " + annotationProperties.level() + " ]\n");
            }
        }
    }
}
