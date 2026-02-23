package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Practice Problem 5: Implement a Role-Based Access Control with @RoleAllowed
 */

// Step 1: Definition of the custom runtime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Applies access restriction per method logic
@interface RoleAllowed {
    String value(); // Represents the Authorized User Role
}

// Step 2: Implementation class decorating methods
class AdminDashboard {

    // Explicit assignment of Admin property to access resource logic block
    @RoleAllowed("ADMIN")
    public void deleteUserAccount(String username) {
        System.out.println("Processing System Delete Execution for target Identity: '" + username + "'\n");
    }

    // Explicit assignment of Manager property to access system data overview
    @RoleAllowed("MANAGER")
    public void generateMonthlyFinancialReport() {
        System.out.println("Generating Business Overview Summary.\n");
    }

    // Unrestricted block logic accessible by any Identity level
    public void viewPublicAnnouncements() {
        System.out.println("Displaying Public System Bulletins.\n");
    }
}

public class RoleBasedAccessDemo {

    // Simulating security gate evaluation logic
    public static void secureInvoke(Object requestObjectTarget, String invokedMethodCall,
            String userIdentityTargetType) {
        try {
            Class<?> clazz = requestObjectTarget.getClass();

            // Identifying method to process request with single String arg, or no args
            Method method = null;
            Object[] args = null;

            if (invokedMethodCall.equals("deleteUserAccount")) {
                method = clazz.getMethod(invokedMethodCall, String.class);
                args = new Object[] { "SuspiciousUser101" };
            } else {
                method = clazz.getMethod(invokedMethodCall);
                args = new Object[0];
            }

            System.out.println(
                    "User {" + userIdentityTargetType + "} requesting execution of: '" + method.getName() + "()'");

            // Verifying the presence of @RoleAllowed security requirement on target methods
            // before execution
            if (method.isAnnotationPresent(RoleAllowed.class)) {

                // Fetch Authorized Identity Group definition within decorator logic
                RoleAllowed assignedSecurityRequirement = method.getAnnotation(RoleAllowed.class);
                String authorizedIdentityGroup = assignedSecurityRequirement.value();

                // Validate execution rights based on matched Authentication Property Criteria
                if (!authorizedIdentityGroup.equals(userIdentityTargetType)) {
                    System.err.println("[ACCESS DENIED] User Identity belongs to: '" + userIdentityTargetType +
                            "'. This method requires: '" + authorizedIdentityGroup + "' Privilege Level!\n");
                    return; // Prevent invocation
                } else {
                    System.out.println("[ACCESS GRANTED] Authorization valid for Identity Group: '"
                            + userIdentityTargetType + "'");
                }
            } else {
                System.out.println("[PUBLIC ACCESS] No specific Privilege Group constraints apply.");
            }

            // Process the method logically internally once granted Authentication status
            // requirement
            method.invoke(requestObjectTarget, args);

        } catch (NoSuchMethodException e) {
            System.err.println("Requested Execution Logic not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Method Access Gate Demonstrator Evaluator ---\n");
        AdminDashboard instanceObjectLogicProcessor = new AdminDashboard();

        // Admin attempting authorized logic
        secureInvoke(instanceObjectLogicProcessor, "deleteUserAccount", "ADMIN");

        // General Employee attempting Unauthorized Admin Block Call
        secureInvoke(instanceObjectLogicProcessor, "deleteUserAccount", "EMPLOYEE");

        // Manager attempting authorized Logic Call Flow Execution
        secureInvoke(instanceObjectLogicProcessor, "generateMonthlyFinancialReport", "MANAGER");

        // Public action
        secureInvoke(instanceObjectLogicProcessor, "viewPublicAnnouncements", "GUEST");
    }
}
