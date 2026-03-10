package jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JsonFileReaderAndExtractor {
    public static void main(String[] args) {
        String filePath = "jsondata/user.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file as a Tree
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Extract specific fields (name, email)
            System.out.println("--- Extracting Specific Fields ---");
            if (rootNode.has("name") && rootNode.has("email")) {
                String name = rootNode.get("name").asText();
                String email = rootNode.get("email").asText();
                System.out.println("Extracted Name: " + name);
                System.out.println("Extracted Email: " + email);
            }

            System.out.println("\n--- Printing All Keys and Values ---");
            printKeysAndValues(rootNode, "");

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }

    // Helper method to recursively print all keys and values
    private static void printKeysAndValues(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.print(prefix + field.getKey() + ": ");
                JsonNode value = field.getValue();
                if (value.isObject() || value.isArray()) {
                    System.out.println();
                    printKeysAndValues(value, prefix + "  ");
                } else {
                    System.out.println(value.asText());
                }
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                System.out.print(prefix + "[" + i + "]: ");
                JsonNode arrayItem = node.get(i);
                if (arrayItem.isObject() || arrayItem.isArray()) {
                    System.out.println();
                    printKeysAndValues(arrayItem, prefix + "  ");
                } else {
                    System.out.println(arrayItem.asText());
                }
            }
        }
    }
}
