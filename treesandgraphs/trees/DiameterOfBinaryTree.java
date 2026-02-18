package treesandgraphs.trees;

/**
 * Diameter of a Binary Tree
 * Problem Statement:
 * Find the diameter of a binary tree.
 * The diameter is the length of the longest path between any two nodes.
 * Constraints: The path may or may not pass through the root.
 * Concepts Tested: Recursion optimization, Height + diameter logic
 */
public class DiameterOfBinaryTree {

    private static int maxDiameter = 0;

    /**
     * Calculates the diameter of a binary tree.
     * The diameter is the length of the longest path between any two nodes in a
     * tree.
     * Use a helper method to calculate height and update diameter simultaneously.
     *
     * @param root The root of the binary tree.
     * @return The diameter of the tree.
     */
    public static int findDiameter(TreeNode root) {
        maxDiameter = 0;
        calculateHeightAndUpdateDiameter(root);
        return maxDiameter;
    }

    /**
     * Helper method to calculate height and update max diameter found so far.
     *
     * @param root The current node.
     * @return The height of the subtree rooted at `root`.
     */
    private static int calculateHeightAndUpdateDiameter(TreeNode root) {
        if (root == null) {
            return 0; // Height of an empty tree is 0
        }

        // Recursively find the height of the left and right subtrees
        int leftHeight = calculateHeightAndUpdateDiameter(root.left);
        int rightHeight = calculateHeightAndUpdateDiameter(root.right);

        // Update the maximum diameter found so far
        // Diameter passing through this node is leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of this node to be used by parent (max depth + 1)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Construct a sample tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of tree: " + findDiameter(root)); // Expected: 3 (path: 4 -> 2 -> 1 -> 3 or 5 -> 2
                                                                       // -> 1 -> 3)
    }
}
