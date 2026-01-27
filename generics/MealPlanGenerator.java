package generics;

/**
 * Personalized Meal Plan Generator.
 * Demonstrates Generic Methods, Type Parameters, and Bounded Type Parameters.
 */
public class MealPlanGenerator {

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = generateMeal(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = generateMeal(new VeganMeal());
        Meal<KetoMeal> ketoMeal = generateMeal(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = generateMeal(new HighProteinMeal());

        System.out.println("--- Your Personalized Meal Plans ---");
        vegMeal.displayMealDetails();
        System.out.println();
        veganMeal.displayMealDetails();
        System.out.println();
        ketoMeal.displayMealDetails();
        System.out.println();
        proteinMeal.displayMealDetails();
    }

    /**
     * Generic method to generate a Meal object.
     * Ensures the input implements MealPlan.
     *
     * @param plan The meal plan object.
     * @param <T>  Type parameter extending MealPlan.
     * @return A new Meal object containing the plan.
     */
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {
        System.out.println("Generating meal plan for: " + plan);
        // Logic to customize or validate could go here
        return new Meal<>(plan);
    }
}

/**
 * Interface representing a Meal Plan.
 */
interface MealPlan {
    String getPlanDetails();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanDetails() {
        return "Vegetarian Plan: No meat, includes dairy and eggs.";
    }

    @Override
    public String toString() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getPlanDetails() {
        return "Vegan Plan: No animal products.";
    }

    @Override
    public String toString() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getPlanDetails() {
        return "Keto Plan: High fat, low carb.";
    }

    @Override
    public String toString() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getPlanDetails() {
        return "High Protein Plan: Focus on lean meats, legumes, and eggs.";
    }

    @Override
    public String toString() {
        return "High Protein";
    }
}

/**
 * Generic Meal class.
 * T is restricted to implementations of MealPlan.
 *
 * @param <T> The meal plan type.
 */
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMealDetails() {
        System.out.println("Meal Plan Type: " + mealPlan);
        System.out.println("Details: " + mealPlan.getPlanDetails());
    }
}
