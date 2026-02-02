package iostreams;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;

/**
 * Problem 3: Read User Input from Console
 * 
 * Writes a program that asks the user for their name, age, and favorite
 * programming language,
 * then saves this information into a file.
 * 
 * Requirements:
 * - Use BufferedReader for console input.
 * - Use FileWriter to write the data into a file.
 * - Handle exceptions properly.
 */
public class ConsoleInputToFile {

    private static final String OUTPUT_FILE = "user_info.txt";

    public static void main(String[] args) {
        // Use try-with-resources for the writer, but NOT for System.in usually
        // as closing System.in closes it for the whole app.
        // However, we can wrap BufferedReader around System.in safely here.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("--- User Information Entry ---");

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String ageStr = reader.readLine();
            int age = 0;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Defaulting to 0.");
            }

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Writing to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                writer.write("User Profile");
                writer.newLine();
                writer.write("----------------------------");
                writer.newLine();
                writer.write("Name: " + name);
                writer.newLine();
                writer.write("Age: " + age);
                writer.newLine();
                writer.write("Favorite Language: " + language);
                writer.newLine();

                System.out.println("Information saved successfully to '" + OUTPUT_FILE + "'.");
            }

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
        // We generally don't close System.in readers in a main method unless we are
        // sure
        // we are done with console input for the entire JVM life.
    }
}
