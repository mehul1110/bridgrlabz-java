package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Exercise 4: Create a Custom Annotation and Use It
 * Problem Statement: Create an annotation @TaskInfo to mark tasks with a
 * priority and a person assigned.
 */

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Necessary to fetch via Reflection during runtime
@Target(ElementType.METHOD) // Scope is limited to method decoration
@interface TaskInfo {
    String priority() default "NORMAL";

    String assignedTo();
}

// Step 2: Decorating methods within a business class
class TaskManager {

    // Applying the Custom Annotation with specific details
    @TaskInfo(priority = "HIGH", assignedTo = "Alice Johnson")
    public void compileMonthlyReports() {
        System.out.println("Executing Task: Compiling Monthly Financial Reports...");
    }

    // Relying on default priority
    @TaskInfo(assignedTo = "Bob Smith")
    public void backupDatabase() {
        System.out.println("Executing Task: Backing up system databases...");
    }
}

public class CustomAnnotationExercise {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercise 4: Validating Custom @TaskInfo Annotations ---");

        TaskManager manager = new TaskManager();
        Class<?> clazz = manager.getClass();

        // Iterating over all methods belonging to TaskManager
        for (Method method : clazz.getDeclaredMethods()) {

            // Checking if the @TaskInfo annotation decorates the specific method
            if (method.isAnnotationPresent(TaskInfo.class)) {

                // Fetch details of annotation via Reflection
                TaskInfo annotationValues = method.getAnnotation(TaskInfo.class);

                System.out.println("\n[Scan Result] Method: " + method.getName());
                System.out.println("  Assignee  : " + annotationValues.assignedTo());
                System.out.println("  Priority  : " + annotationValues.priority());

                // Execute after checking annotation details
                method.invoke(manager);
            }
        }
    }
}
