package designpatterns;

/**
 * Iterator Pattern implementation.
 * Provides a way to access the elements of an aggregate object sequentially
 * without exposing its underlying representation.
 */

// Step 1: Definition mapping generic traversal interface logic
interface CustomIterator {
    boolean hasNextElement();

    Object generateNextElement();
}

// Step 2: Mapping rules for Collections offering traversable access structure
interface ContainerCollection {
    CustomIterator generateIteratorInstance();
}

// Step 3: Implement concrete collection aggregating logic
class NameRepository implements ContainerCollection {
    // Array storing contextual information
    private final String[] storageArrNames = { "Alice", "Bob", "Charlie", "Diana" };

    @Override
    public CustomIterator generateIteratorInstance() {
        return new InternalCollectionIterator();
    }

    // Step 4: Inner class managing custom Iterator traversal implementation
    // structurally tracking positions
    private class InternalCollectionIterator implements CustomIterator {
        private int currentTraversalIndex = 0;

        @Override
        public boolean hasNextElement() {
            // Evaluates execution iteration conditions against total object scope
            return currentTraversalIndex < storageArrNames.length;
        }

        @Override
        public Object generateNextElement() {
            if (this.hasNextElement()) {
                // Returns mapped value property internally managed, then bumps iteration state
                // progression
                return storageArrNames[currentTraversalIndex++];
            }
            return null; // Signals empty fallback termination logical property
        }
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Iterator Pattern Sequencing Traversal Logic...\n");

        System.out.println("Constructing Repository Aggregation instance mapping configurations");
        NameRepository stringNamesRepositoryInstanceObj = new NameRepository();

        System.out.println(
                "\nBeginning Internal Traversal Sequencing without revealing underlying array execution memory pointer size logic:");
        System.out.println("-------------------------");

        // Context abstracts structural traversal complexity delegation
        CustomIterator sequencingReferenceExecutionObj = stringNamesRepositoryInstanceObj.generateIteratorInstance();

        // Loop structural mapping
        while (sequencingReferenceExecutionObj.hasNextElement()) {
            String returnedIterativeValueOutput = (String) sequencingReferenceExecutionObj.generateNextElement();
            System.out.println("Processing Traversed Result Element -> " + returnedIterativeValueOutput);
        }

        System.out.println("-------------------------");
        System.out.println("Execution iteration complete.");
    }
}
