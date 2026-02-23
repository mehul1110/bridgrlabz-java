package reflectionandannotation.reflection;

import java.lang.reflect.Constructor;

/**
 * Demonstrates creating an object dynamically using Reflection without the new
 * keyword.
 */
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreationDemo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Student.class;

            // Get the constructor that takes a String parameter
            Constructor<?> constructor = clazz.getConstructor(String.class);

            // Create a new instance dynamically
            Student student = (Student) constructor.newInstance("Alice Smith");

            // Verify the object is created by calling a method
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
