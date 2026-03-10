package jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        // Create a List of Java Objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 35));

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert the Object List to a JSON Array
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);

            System.out.println("--- List of Java Objects converted to JSON Array ---");
            System.out.println(jsonArray);

        } catch (IOException e) {
            System.err.println("Error converting list to JSON array: " + e.getMessage());
        }
    }
}
