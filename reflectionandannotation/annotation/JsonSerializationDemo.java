package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Practice Problem 6: Implement a Custom Serialization Annotation @JsonField
 */

// Step 1: Definition of the custom runtime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // Target properties
@interface JsonField {
    String name() default ""; // Overrides the property name inside the JSON output
}

// Step 2: Implementation class decorating variables
class UserProfileData {

    @JsonField(name = "account_uuid")
    private int id;

    @JsonField(name = "user_name")
    private String username;

    @JsonField // Defaults to empty String value which will cause fallback logic
    private boolean activeStatus;

    // Transient or unmarked variables should not map to Output String logic
    private String secretPasswordHash;

    public UserProfileData(int id, String username, boolean activeStatus, String secretPasswordHash) {
        this.id = id;
        this.username = username;
        this.activeStatus = activeStatus;
        this.secretPasswordHash = secretPasswordHash;
    }
}

public class JsonSerializationDemo {

    public static String mapToJson(Object sourceDataInstance) {
        if (sourceDataInstance == null)
            return "null";

        Class<?> instanceClass = sourceDataInstance.getClass();

        // Output Construction builder string block logic
        StringBuilder jsonConstructLogic = new StringBuilder("{\n");

        Field[] propertiesList = instanceClass.getDeclaredFields();
        boolean prependComma = false;

        for (int i = 0; i < propertiesList.length; i++) {
            Field instanceProperty = propertiesList[i];

            // Check property metadata matching the @JsonField specification
            if (instanceProperty.isAnnotationPresent(JsonField.class)) {

                // Force access private visibility constraints if flagged as mapped object
                instanceProperty.setAccessible(true);

                try {
                    JsonField mappingDetails = instanceProperty.getAnnotation(JsonField.class);

                    // Priority fallback logic if empty mapped property
                    String mappedJsonKey = mappingDetails.name().isEmpty() ? instanceProperty.getName()
                            : mappingDetails.name();

                    // Evaluate object mapping string property
                    Object mappingJsonValue = instanceProperty.get(sourceDataInstance);

                    if (prependComma) {
                        jsonConstructLogic.append(",\n");
                    }

                    jsonConstructLogic.append("  \"").append(mappedJsonKey).append("\": ");

                    // Determine syntax wrapping execution conditional
                    if (mappingJsonValue instanceof String) {
                        jsonConstructLogic.append("\"").append(mappingJsonValue).append("\"");
                    } else {
                        jsonConstructLogic.append(mappingJsonValue);
                    }

                    prependComma = true;

                } catch (IllegalAccessException e) {
                    System.err.println(
                            "Accessibility constraint blocked read action instance on System Mapped properties logic.");
                }
            }
        }
        jsonConstructLogic.append("\n}");
        return jsonConstructLogic.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- @JsonField Source Serializer Engine --- \n");

        UserProfileData instanceExample = new UserProfileData(101, "admin123", true, "super_secret_hash_code");

        System.out.println("Processing Source Property Instances internally:\n");

        String mappingStringResultOutput = mapToJson(instanceExample);

        System.out.println("Serialized Mapped Target Logic Result:\n" + mappingStringResultOutput);
    }
}
