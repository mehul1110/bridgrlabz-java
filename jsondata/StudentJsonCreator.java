package jsondata;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJsonCreator {
    public static void main(String[] args) {
        // Create a JSON array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Computer Science");

        // Create a JSON object for Student
        JSONObject student = new JSONObject();
        student.put("name", "John Doe");
        student.put("age", 20);
        student.put("subjects", subjects);

        // Print the JSON object
        System.out.println("Student JSON Object:");
        System.out.println(student.toString(4)); // Pretty print with indent factor 4
    }
}
