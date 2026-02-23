package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Exercise 5: Create and Use a Repeatable Annotation
 * Problem Statement: Implement an annotation @BugReport that can be applied
 * multiple times to a single element.
 */

// Step 1: Create a Container Annotation that holds an array of the repeatable
// annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define a repeatable @BugReport using @Repeatable wrapper
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();

    String severity() default "MINOR";
}

// Step 3: Implement Multiple Annotations
class VulnerableSystem {

    // Allow applying the annotation several times
    @BugReport(description = "Null pointer exception crash on empty arguments", severity = "CRITICAL")
    @BugReport(description = "Response timeout on valid connections under heavy load", severity = "MAJOR")
    @BugReport(description = "GUI flickering during data rendering")
    public void executeVulnerableProcess() {
        System.out.println("Processing System Checks... Encountering Bugs!");
    }
}

public class RepeatableAnnotationExercise {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercise 5: Creating and Parsing @Repeatable Annotations ---\n");

        Class<?> clazz = VulnerableSystem.class;
        Method targetMethod = clazz.getMethod("executeVulnerableProcess");

        // Step 4: Access an array of recurring annotations from Method
        if (targetMethod.isAnnotationPresent(BugReports.class)) {
            BugReport[] repeatingInstances = targetMethod.getAnnotationsByType(BugReport.class);
            System.out.println("Found " + repeatingInstances.length + " unresolved issues in method: '"
                    + targetMethod.getName() + "()'\n");

            // Evaluate individually
            for (BugReport report : repeatingInstances) {
                System.out
                        .println("[ISSUE FOUND] Severity (" + report.severity() + ") - Cause: " + report.description());
            }
        }
    }
}
