package jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "jsondata/ipl.csv";
        String jsonOutputPath = "jsondata/ipl_converted.json";

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode rootArrayNode = objectMapper.createArrayNode();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(",");

                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    ObjectNode jsonNode = objectMapper.createObjectNode();
                    for (int i = 0; i < headers.length && i < data.length; i++) {
                        // Assuming string format for all fields to avoid type checking complexity
                        jsonNode.put(headers[i].trim(), data[i].trim());
                    }
                    rootArrayNode.add(jsonNode);
                }
            }

            // Write Output
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonOutputPath), rootArrayNode);
            System.out.println("Converted CSV data into JSON successfully. Output: " + jsonOutputPath);

            // Preview output
            System.out.println("\nPreview of JSON:");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootArrayNode));

        } catch (IOException e) {
            System.err.println("Error parsing or writing CSV/JSON format: " + e.getMessage());
        }
    }
}
