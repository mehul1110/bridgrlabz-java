package designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor Pattern implementation.
 * Adds new operations to a class of elements without modifying their structural
 * logic.
 */

// Step 1: Definition of Element Structure allowing Data extraction mapping
// execution
interface ItemCollectionElement {
    // Structural method enabling execution Logic injection dynamically
    int acceptLogicInterpretation(ShoppingCartVisitor computationLogicVisitor);
}

// Step 2: Concrete Items mapping logical parameters
class BookItem implements ItemCollectionElement {
    private final int itemPriceVal;
    private final String itemIsbnLogic;

    public BookItem(int itemPriceVal, String itemIsbnLogic) {
        this.itemPriceVal = itemPriceVal;
        this.itemIsbnLogic = itemIsbnLogic;
    }

    public int getPriceValue() {
        return itemPriceVal;
    }

    public String getIsbnNumber() {
        return itemIsbnLogic;
    }

    @Override
    public int acceptLogicInterpretation(ShoppingCartVisitor calculationLogicExecVisitor) {
        // Delegates logic logic execution implementation dynamically
        return calculationLogicExecVisitor.visitDataCalculation(this);
    }
}

class ElectronicsItem implements ItemCollectionElement {
    private final int purchasePriceValue;
    private final int baseWeightInKg;
    private final String brandNameId;

    public ElectronicsItem(int purchasePriceValue, int weightInKg, String brandNameId) {
        this.purchasePriceValue = purchasePriceValue;
        this.baseWeightInKg = weightInKg;
        this.brandNameId = brandNameId;
    }

    public int fetchBaseItemCost() {
        return purchasePriceValue;
    }

    public int fetchDeviceWeight() {
        return baseWeightInKg;
    }

    public String identifyBrand() {
        return brandNameId;
    }

    @Override
    public int acceptLogicInterpretation(ShoppingCartVisitor processingCalculationVisitor) {
        return processingCalculationVisitor.visitDataCalculation(this);
    }
}

// Step 3: Define operation properties mapping execution variations functionally
interface ShoppingCartVisitor {
    int visitDataCalculation(BookItem selectedBookObjNode);

    int visitDataCalculation(ElectronicsItem selectedDeviceNode);
}

// Step 4: Concrete Visitor Processing Algorithmic configurations
class StandardPriceCalculatorVisitor implements ShoppingCartVisitor {
    @Override
    public int visitDataCalculation(BookItem itemNode) {
        int finalBookCost = itemNode.getPriceValue();
        if (finalBookCost > 50) {
            System.out.println("Processing Book Price Rule -> Automatically applying $5 Discount (ISBN: "
                    + itemNode.getIsbnNumber() + ")");
            finalBookCost -= 5;
        } else {
            System.out.println(
                    "Processing Book Cost calculation (ISBN: " + itemNode.getIsbnNumber() + ") = $" + finalBookCost);
        }
        return finalBookCost;
    }

    @Override
    public int visitDataCalculation(ElectronicsItem techNodeObj) {
        int targetDeviceCost = techNodeObj.fetchBaseItemCost();
        // Specific Structural Logic executing computation based on Weight Property
        // Logic
        int additionalShippingCharge = (techNodeObj.fetchDeviceWeight() > 2) ? 15 : 5;
        System.out.println("Processing Electronic Rule -> Applying Shipping Rate +$" + additionalShippingCharge
                + " for " + techNodeObj.identifyBrand() + " device.");

        return targetDeviceCost + additionalShippingCharge;
    }
}

public class VisitorPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Visitor Algorithmic Calculation Logic Structuring...\n");

        List<ItemCollectionElement> shoppingCartContentsListItems = new ArrayList<>();
        // Configuring Base Object Elements logic internally
        shoppingCartContentsListItems.add(new BookItem(25, "B-00124-XY"));
        shoppingCartContentsListItems.add(new BookItem(70, "B-91024-AA"));
        shoppingCartContentsListItems.add(new ElectronicsItem(450, 4, "Dell Horizon"));

        ShoppingCartVisitor priceExecutionRuleEngine = new StandardPriceCalculatorVisitor();

        System.out.println("--- Initiating Visitor Execution Procedure Execution ---");
        int finalCheckoutSumValueTotal = 0;

        // Loop structural mapping
        for (ItemCollectionElement currentItemObjNode : shoppingCartContentsListItems) {
            // Apply Logic algorithm visitor executing rules configurations
            finalCheckoutSumValueTotal += currentItemObjNode.acceptLogicInterpretation(priceExecutionRuleEngine);
        }

        System.out.println("\n-----------------------------");
        System.out.println("Computation Execution resolved Total = $" + finalCheckoutSumValueTotal);
    }
}
