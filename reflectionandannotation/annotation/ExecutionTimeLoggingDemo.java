package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Practice Problem 3: Create an Annotation for Logging Method Execution Time
 */

// Step 1: Definition of the runtime Log Execution Time Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

// Step 2: Implementation class decorating methods
class WorkerTasks {

    // Flag this method for Execution Timing execution
    @LogExecutionTime
    public void executeHeavyCalculation() throws InterruptedException {
        // Simulate a resource-intensive computing operation
        Thread.sleep(750);
        System.out.println("Finished Heavy Computing Logic.");
    }

    // Flag this method for Execution Timing execution
    @LogExecutionTime
    public void executeLightCalculation() throws InterruptedException {
        // Simulate a minor task execution
        Thread.sleep(100);
        System.out.println("Finished Light Processing Query.");
    }
}

public class ExecutionTimeLoggingDemo {

    public static void executeAndLogTime(WorkerTasks instance, Method method) throws Exception {
        System.out.println("Starting execution tracker for Method: '" + method.getName() + "()'");

        long startTime = System.nanoTime();

        // Dynamic Method Invocation via Reflection
        method.invoke(instance);

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000; // Convert from nanoseconds to milliseconds

        System.out.println("[PERFORMANCE LOG] -> '" + method.getName() + "()' took: " + executionTime + " ms\n");
    }

    public static void main(String[] args) {
        System.out.println("--- Log Execution Time Demonstration based on @LogExecutionTime Annotation ---\n");
        WorkerTasks instance = new WorkerTasks();

        Class<?> clazz = instance.getClass();

        // Loop through all methods belonging to the WorkerTasks Class definition
        for (Method method : clazz.getDeclaredMethods()) {

            // Verifying the presence of @LogExecutionTime metadata decorators
            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                try {
                    // Process the method logically under the track time decorator
                    executeAndLogTime(instance, method);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
