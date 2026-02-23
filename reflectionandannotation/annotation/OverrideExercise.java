package reflectionandannotation.annotation;

/**
 * Exercise 1: Use @Override Correctly
 * Problem Statement:
 * Create a parent class Animal with a method makeSound(). Then, create a Dog
 * class that overrides this method using @Override.
 */
class Animal {
    // Parent method intended to be overridden by subclasses
    public void makeSound() {
        System.out.println("The animal makes a generic sound.");
    }
}

class Dog extends Animal {
    // Explicitly denoting that this method overrides the superclass method
    // Helps catch typos or signature mismatches at compile time
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof! Woof!");
    }
}

public class OverrideExercise {
    public static void main(String[] args) {
        // Instantiate the subclass
        Animal myDog = new Dog();

        // Execute the overridden subclass behavior
        System.out.println("--- Exercise 1: Demonstrating @Override ---");
        myDog.makeSound();
    }
}
