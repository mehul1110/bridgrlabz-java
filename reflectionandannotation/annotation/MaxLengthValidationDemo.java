package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Practice Problem 4: Create a @MaxLength Annotation for Field Validation
 */

// Step 1: Definition of the runtime field validation Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value(); // Required Attribute defining Max Length Limit
}

// Step 2: Decorating a String field within a business Model
class UserAccount {

    // Validating Maximum Limit allowed to input on instantiation target
    @MaxLength(value = 10)
    private String username;

    public UserAccount(String username) {
        this.username = username;

        try {
            // Initiate object validation logic within the instantiation via Custom
            // Decorator
            validateFields();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.err.println("Validation Error on Instantiation: " + e.getMessage());
            // In a real application, you might rethrow or reject object creation
        }
    }

    private void validateFields() throws IllegalArgumentException, IllegalAccessException {
        // Step 3: Loop through all fields inside current Object Definition via
        // Reflection
        for (Field field : this.getClass().getDeclaredFields()) {

            // Check specific instance variables holding our Max Length verification
            // Decorator
            if (field.isAnnotationPresent(MaxLength.class)) {

                MaxLength maxLengthAnnotation = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);

                // Get original field metadata to cast the variable and enforce Length property
                // constraints
                String fieldValue = (String) field.get(this);
                int maximumLengthlimit = maxLengthAnnotation.value();

                if (fieldValue != null && fieldValue.length() > maximumLengthlimit) {

                    // Block excessive Length via Error reporting framework
                    throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' length '" + fieldValue.length() +
                                    "' exceeds the configured maximum length of [" + maximumLengthlimit + "]");
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthValidationDemo {
    public static void main(String[] args) {
        System.out.println("--- @MaxLength Field Constraint Evaluator ---\n");

        System.out.println("Attempting to populate Object with a Username under length limit [10]...");
        UserAccount validUser = new UserAccount("admin_01");
        System.out.println("[SUCCESS] Created Valid Identity User: " + validUser.getUsername() + "\n");

        System.out.println("Attempting to populate Object with excessive string property above limit [10]...");
        UserAccount invalidUser = new UserAccount("AdminUserVeryLongUsername");
        // Handled within instantiation internally
    }
}
