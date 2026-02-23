package reflectionandannotation.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to mark a class with its author name.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name() default "Unknown";
}

// Applying the custom annotation to a class
@Author(name = "Alice Smith")
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

public class RetrieveAnnotationsDemo {
    public static void main(String[] args) {
        Class<?> clazz = Book.class;

        // Check if the @Author annotation is present on the class
        if (clazz.isAnnotationPresent(Author.class)) {
            // Retrieve the annotation details at runtime
            Author authorAnnotation = clazz.getAnnotation(Author.class);
            System.out
                    .println("Class '" + clazz.getSimpleName() + "' is written by Author: " + authorAnnotation.name());
        } else {
            System.out.println("The @Author annotation is not present on class: " + clazz.getSimpleName());
        }
    }
}
