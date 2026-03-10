package jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;

public class ParseAndFilterJson {
    public static void main(String[] args) {
        String jsonData = "[\n" +
                "  {\"name\": \"Alice\", \"age\": 22},\n" +
                "  {\"name\": \"Bob\", \"age\": 28},\n" +
                "  {\"name\": \"Charlie\", \"age\": 35},\n" +
                "  {\"name\": \"David\", \"age\": 25}\n" +
                "]";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse JSON String into a JsonNode tree
            JsonNode rootNode = objectMapper.readTree(jsonData);

            // Assuming root is an array
            if (rootNode.isArray()) {
                System.out.println("--- Users Older Than 25 ---");

                // Using ArrayNode to store the filtered results
                ArrayNode filteredUsers = objectMapper.createArrayNode();

                for (JsonNode node : rootNode) {
                    if (node.has("age")) {
                        int age = node.get("age").asInt();
                        if (age > 25) {
                            filteredUsers.add(node);
                            System.out.println("User: " + node.get("name").asText() + " (Age: " + age + ")");
                        }
                    }
                }

                System.out.println("\nFiltered JSON Array:");
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers));

            }

        } catch (IOException e) {
            System.err.println("Error parsing and filtering JSON: " + e.getMessage());
        }
    }
}
