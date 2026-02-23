package designpatterns;

/**
 * Bridge Pattern implementation.
 * Decouples an abstraction from its implementation so both can vary
 * independently.
 */

// Implementation interface for painting colors
interface Color {
    void applyColor();
}

// Concrete Implementations defining different colors
class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Red color hue.");
    }
}

class Blue implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Blue color hue.");
    }
}

// Abstraction mapped structurally utilizing the color implementations
abstract class ColoredShape {
    protected Color colorInstance;

    // The Abstraction component uses a reference to the Interface defining standard
    // rules
    public ColoredShape(Color color) {
        this.colorInstance = color;
    }

    abstract void drawShapeLogic();
}

// Refined Abstractions applying Bridge to combine geometry with properties
// decoupled
class CircleShape extends ColoredShape {
    public CircleShape(Color color) {
        super(color);
    }

    @Override
    void drawShapeLogic() {
        System.out.print("Drawing Circle Geometry... ");
        // Utilizing decoupled color
        colorInstance.applyColor();
    }
}

class SquareShape extends ColoredShape {
    public SquareShape(Color color) {
        super(color);
    }

    @Override
    void drawShapeLogic() {
        System.out.print("Drawing Square Geometry... ");
        // Utilizing decoupled color structure definition
        colorInstance.applyColor();
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Bridge Pattern...\n");

        System.out.println("Combining varying Shape Structures and Colored implementations at Runtime:");

        // Connect Abstraction (Shape) -> Implementation (Red Color)
        ColoredShape redCircle = new CircleShape(new Red());
        redCircle.drawShapeLogic();

        // Connect Abstraction (Shape) -> Implementation (Blue Color)
        ColoredShape blueSquare = new SquareShape(new Blue());
        blueSquare.drawShapeLogic();
    }
}
