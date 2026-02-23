package designpatterns;

/**
 * Factory Method Pattern implementation.
 * Defines an interface for object creation, but lets subclasses decide which
 * class to instantiate.
 */
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}

// Factory class to generate objects based on input criteria
class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }
}

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        System.out.println("Testing Factory Method Pattern...\n");

        // Use factory method to fetch a specific shape
        Shape circleResult = ShapeFactory.getShape("CIRCLE");
        if (circleResult != null) {
            circleResult.draw();
        }

        Shape rectangleResult = ShapeFactory.getShape("RECTANGLE");
        if (rectangleResult != null) {
            rectangleResult.draw();
        }

        Shape invalidShape = ShapeFactory.getShape("TRIANGLE");
        if (invalidShape == null) {
            System.out.println("Tried to create a Triangle, but the factory returned null as it's not supported yet.");
        }
    }
}
