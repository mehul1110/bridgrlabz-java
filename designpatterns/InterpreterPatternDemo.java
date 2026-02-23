package designpatterns;

/**
 * Interpreter Pattern implementation.
 * Defines a grammar for a language and parses/interprets expressions.
 */

// Step 1: Abstract Expression defining the interpretation operation mapping
// logic
interface InterpretationExpression {
    int evaluateResult(); // Returns interpreted execution
}

// Step 2: Terminal Expression logically returning concrete numerical values
// structurally
class NumberExpression implements InterpretationExpression {
    private final int constantValue;

    public NumberExpression(int value) {
        this.constantValue = value;
    }

    @Override
    public int evaluateResult() {
        return this.constantValue; // Resolves base computation unit logically
    }
}

// Step 3: Non-Terminal Expression evaluating rules mapping properties
// configurations
class AdditionExpression implements InterpretationExpression {
    private final InterpretationExpression lhsContext; // Left Hand Side Statement Logic
    private final InterpretationExpression rhsContext; // Right Hand Side Statement Logic

    public AdditionExpression(InterpretationExpression lhs, InterpretationExpression rhs) {
        this.lhsContext = lhs;
        this.rhsContext = rhs;
    }

    // Resolves logic execution
    @Override
    public int evaluateResult() {
        return lhsContext.evaluateResult() + rhsContext.evaluateResult();
    }
}

class SubtractionExpression implements InterpretationExpression {
    private final InterpretationExpression lhsContext;
    private final InterpretationExpression rhsContext;

    public SubtractionExpression(InterpretationExpression lhs, InterpretationExpression rhs) {
        this.lhsContext = lhs;
        this.rhsContext = rhs;
    }

    @Override
    public int evaluateResult() {
        return lhsContext.evaluateResult() - rhsContext.evaluateResult();
    }
}

public class InterpreterPatternDemo {
    // Utility mapping Context Statement Logic Parser Configuration
    public static InterpretationExpression buildExpressionSyntaxTree(String computationStatementContext) {
        System.out.println(
                "Processing Interpreter Parsing Logic for Syntax Statement: '" + computationStatementContext + "'");

        // Simulating Parser Logic translating "5 + 10" or "8 - 2" statement constructs
        String[] parsedElementsArr = computationStatementContext.split(" ");
        if (parsedElementsArr.length == 3) {
            InterpretationExpression leftTerminalNode = new NumberExpression(Integer.parseInt(parsedElementsArr[0]));
            InterpretationExpression rightTerminalNode = new NumberExpression(Integer.parseInt(parsedElementsArr[2]));

            String mathematicalOperator = parsedElementsArr[1];

            // Delegate Expression execution rules context depending on Syntax grammar
            if ("+".equals(mathematicalOperator)) {
                return new AdditionExpression(leftTerminalNode, rightTerminalNode);
            } else if ("-".equals(mathematicalOperator)) {
                return new SubtractionExpression(leftTerminalNode, rightTerminalNode);
            }
        }
        throw new IllegalArgumentException("Syntax rules context failed formatting requirements.");
    }

    public static void main(String[] args) {
        System.out.println("Testing Interpreter Pattern Processing...\n");

        // Use parsing utility building Grammar structure Context Logic Node Tree
        // Evaluator
        InterpretationExpression additionExecutionNodeSequence = buildExpressionSyntaxTree("5 + 10");
        System.out.println("Execution Computation Interpretation Output: "
                + additionExecutionNodeSequence.evaluateResult() + "\n");

        InterpretationExpression subtractionExecutionNodeSequence = buildExpressionSyntaxTree("25 - 12");
        System.out.println(
                "Execution Computation Interpretation Output: " + subtractionExecutionNodeSequence.evaluateResult());
    }
}
