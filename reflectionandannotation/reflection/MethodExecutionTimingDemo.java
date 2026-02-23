package reflectionandannotation.reflection;

import java.lang.reflect.Method;

/**
 * Demonstrates measuring the execution time of dynamically invoked methods via
 * Reflection.
 */
class ReportGenerator {

    public void generateReportA() throws InterruptedException {
        // Simulate a long-running report generation task
        Thread.sleep(1250);
        System.out.println("Successfully generated Report A.");
    }

    public void generateReportB() throws InterruptedException {
        // Simulate a shorter task
        Thread.sleep(250);
        System.out.println("Successfully generated Report B.");
    }
}

public class MethodExecutionTimingDemo {

    /**
     * Finds and executes a method by its string name, measuring elapsed time
     * dynamically.
     */
    public static void executeAndMeasureTime(Object targetObject, String methodName) {
        try {
            Class<?> clazz = targetObject.getClass();
            Method method = clazz.getMethod(methodName);

            System.out.println("Starting execution of method: " + methodName + "...");
            long startTime = System.currentTimeMillis();

            // Execute method dynamically
            method.invoke(targetObject);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println(
                    "[TIMING] '" + methodName + "' execution finished! Time elapsed: " + executionTime + " ms\n");

        } catch (NoSuchMethodException e) {
            System.out.println(
                    "Error: Method '" + methodName + "' not found within " + targetObject.getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();

        System.out.println("--- Method Timing Analyzer ---");

        // Measure the time for each target method dynamically
        executeAndMeasureTime(generator, "generateReportA");
        executeAndMeasureTime(generator, "generateReportB");
    }
}
