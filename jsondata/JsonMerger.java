package jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonMerger {
    public static void main(String[] args) {
        String file1Path = "jsondata/data1.json";
        String file2Path = "jsondata/data2.json";
        String mergedFilePath = "jsondata/merged.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read both JSON files
            JsonNode node1 = objectMapper.readTree(new File(file1Path));
            JsonNode node2 = objectMapper.readTree(new File(file2Path));

            // Merge node2 into node1 (Assuming both are objects)
            if (node1.isObject() && node2.isObject()) {
                ObjectNode mergedNode = ((ObjectNode) node1).deepCopy();
                mergedNode.setAll((ObjectNode) node2);

                // Print the merged node
                System.out.println("--- Merged JSON Object ---");
                String prettyMergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
                System.out.println(prettyMergedJson);

                // Optionally write to a new file
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(mergedFilePath), mergedNode);
                System.out.println("Merged JSON saved to: " + mergedFilePath);
            } else {
                System.err.println("Both JSON files must contain root objects to merge seamlessly.");
            }
        } catch (IOException e) {
            System.err.println("Error merging JSON files: " + e.getMessage());
        }
    }
}
