package jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class JsonValidator {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File("jsondata/schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load JSON Data to be validated
            JsonNode validEmailJson = objectMapper.readTree("{\"email\": \"alice@example.com\"}");
            JsonNode invalidEmailJson = objectMapper.readTree("{\"email\": \"invalid-email\"}");

            // Validate Valid JSON
            System.out.println("Validating: " + validEmailJson.toString());
            boolean isValid1 = schema.validate(validEmailJson).isSuccess();
            System.out.println("Status: " + (isValid1 ? "JSON is valid!" : "Invalid JSON!"));

            // Validate Invalid JSON
            System.out.println("Validating: " + invalidEmailJson.toString());
            boolean isValid2 = schema.validate(invalidEmailJson).isSuccess();
            System.out.println("Status: " + (isValid2 ? "JSON is valid!" : "Invalid JSON!"));

        } catch (IOException | ProcessingException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}
