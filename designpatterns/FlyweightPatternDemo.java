package designpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Pattern implementation.
 * Reduces memory usage by sharing common object states.
 */

// Shared Extrinsic state generic class representation (Flyweight Interface
// style)
class Font {
    private final String fontFamily;
    private final int size;
    private final boolean isBold;

    // This data is shared to minimize object accumulation
    public Font(String fontFamily, int size, boolean isBold) {
        this.fontFamily = fontFamily;
        this.size = size;
        this.isBold = isBold;
    }

    public void applyFontInfo(char character, int documentPositionX, int documentPositionY) {
        System.out.println(
                "Processing Character '" + character + "' at (X:" + documentPositionX + ", Y:" + documentPositionY +
                        ") [Font: " + fontFamily + ", Size: " + size + ", Bold? " + isBold + "]");
    }
}

// Factory handling Flyweight Object Creation Memory Sharing
class FontFactory {
    private static final Map<String, Font> fontCacheMap = new HashMap<>();

    public static Font retrieveFont(String fontFamily, int size, boolean isBold) {
        // Build Hash Key combining extrinsic attributes
        String uniqueKeyStr = fontFamily + "_" + size + "_" + isBold;

        // Checking existing cached Object Data values
        if (!fontCacheMap.containsKey(uniqueKeyStr)) {
            // Expensive New operation memory usage optimization skipped typically
            Font newFontInstanceToCache = new Font(fontFamily, size, isBold);
            fontCacheMap.put(uniqueKeyStr, newFontInstanceToCache);
            System.out.println("[CREATING NEW IN MEMORY] Generated Font Properties Cache: {" + uniqueKeyStr + "}");
        } else {
            System.out.println("[REUSING CACHED VALUE] Sharing existing memory instance: {" + uniqueKeyStr + "}");
        }

        return fontCacheMap.get(uniqueKeyStr);
    }
}

// Context logic representing the Context dependent Unshared Objects variables
class CharacterText {
    // Unique data instance specific properties
    private char targetValue;
    private int positionCoordX;
    private int positionCoordY;

    // Pointing instance reference towards Shared Immutable properties memory
    // reference object
    private Font sharedStyleFont;

    public CharacterText(char targetValue, int posCoordX, int posCoordY, Font sharedStyle) {
        this.targetValue = targetValue;
        this.positionCoordX = posCoordX;
        this.positionCoordY = posCoordY;
        this.sharedStyleFont = sharedStyle;
    }

    public void printCharDisplay() {
        // Resolving properties mapping call delegation structure mapping logic
        sharedStyleFont.applyFontInfo(targetValue, positionCoordX, positionCoordY);
    }
}

public class FlyweightPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Flyweight Pattern Memory Usage Efficiency...\n");

        // Factory fetching object instances generating them structurally cached
        Font defaultArialSystemFont = FontFactory.retrieveFont("Arial", 12, false);
        Font boldHeadingFont = FontFactory.retrieveFont("Arial", 24, true);

        // Identical parameters trigger Cache Retrieval Sharing Execution Optimization
        // mapping route
        Font reusedDefaultFontInstanceCachePull = FontFactory.retrieveFont("Arial", 12, false);

        System.out.println("\nRendering Document Text Blocks Characters logic iteration:");

        // Characters use shared references conserving memory space structurally
        CharacterText c1 = new CharacterText('H', 10, 20, boldHeadingFont);
        CharacterText c2 = new CharacterText('e', 20, 20, defaultArialSystemFont);
        CharacterText c3 = new CharacterText('l', 30, 20, reusedDefaultFontInstanceCachePull);

        c1.printCharDisplay();
        c2.printCharDisplay();
        c3.printCharDisplay();
    }
}
