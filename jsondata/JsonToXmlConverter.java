package jsondata;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        String jsonFormat = "{\n" +
                "  \"user\": {\n" +
                "    \"name\": \"Alice\",\n" +
                "    \"age\": 25,\n" +
                "    \"email\": \"alice@example.com\"\n" +
                "  }\n" +
                "}";

        System.out.println("--- Original JSON Data ---");
        System.out.println(jsonFormat);

        try {
            // Convert JSON Object to XML String
            JSONObject jsonObject = new JSONObject(jsonFormat);
            String xmlFormat = XML.toString(jsonObject);

            System.out.println("\n--- Converted XML Formatted Data ---");
            System.out.println(xmlFormat);
        } catch (Exception e) {
            System.err.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}
