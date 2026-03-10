package jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class DatabaseJsonReport {

    // Simple mocked representation of a DB record
    static class DBRecord {
        int id;
        String name;
        String department;
        double salary;

        DBRecord(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        // Mock DB connection getting records
        DBRecord[] records = {
                new DBRecord(1, "Alice", "Engineering", 75000),
                new DBRecord(2, "Bob", "HR", 55000),
                new DBRecord(3, "Charlie", "Marketing", 65000)
        };

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode reportArray = objectMapper.createArrayNode();

        // Convert DB records to JSON objects
        for (DBRecord record : records) {
            ObjectNode jsonRecord = objectMapper.createObjectNode();
            jsonRecord.put("employee_id", record.id);
            jsonRecord.put("full_name", record.name);
            jsonRecord.put("dept", record.department);
            jsonRecord.put("compensation", record.salary);
            reportArray.add(jsonRecord);
        }

        try {
            // Write JSON report to a file
            String reportPath = "jsondata/db_report.json";
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportPath), reportArray);

            System.out.println("JSON Report successfully generated at: " + reportPath);

            // Also print to console
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reportArray));
        } catch (IOException e) {
            System.err.println("Error generating JSON report: " + e.getMessage());
        }
    }
}
