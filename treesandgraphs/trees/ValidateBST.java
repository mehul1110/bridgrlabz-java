package treesandgraphs.trees;

/**
 * Validate Binary Search Tree
 * Problem Statement:
 * Given a binary tree, determine whether it is a valid Binary Search Tree
 * (BST).
 * Rules:
 * - Left subtree values < root
 * - Right subtree values > root
 * Concepts Tested: BST properties, Inorder traversal
 */
public class ValidateBST {

    /**
     * Checks if a binary tree is a valid Binary Search Tree (BST).
     *
     * @param root The root of the binary tree.
     * @return True if it is a valid BST, false otherwise.
     */
    public static boolean isValid(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Recursive helper check for BST property.
     *
     * @param node The current node.
     * @param min  The minimum allowed value for this node.
     * @param max  The maximum allowed value for this node.
     * @return True if valid, false otherwise.
     */
    private static boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true; // Empty tree is valid
        }

        // Check if the current node's value violates the min/max constraints
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check subtrees with updated constraints
        // Left child must be smaller than current node
        // Right child must be larger than current node
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Construct a sample BST:
        // 4
        // / \
        // 2 6
        // / \ / \
        // 1 3 5 7
        TreeNode bstRoot = new TreeNode(4);
        bstRoot.left = new TreeNode(2);
        bstRoot.right = new TreeNode(6);
        bstRoot.left.left = new TreeNode(1);
        bstRoot.left.right = new TreeNode(3);
        bstRoot.right.left = new TreeNode(5);
        bstRoot.right.right = new TreeNode(7);

        System.out.println("Is valid BST (balanced BST): " + isValid(bstRoot)); // Expected: true

        // Construct a non-BST:
        // 1
        // / \
        // 2 3
        TreeNode nonBstRoot = new TreeNode(1);
        nonBstRoot.left = new TreeNode(2); // 2 > 1 but on left -> Invalid for standard BST (usually left < root)
        nonBstRoot.right = new TreeNode(3);

        System.out.println("Is valid BST (non-BST): " + isValid(nonBstRoot)); // Expected: false
    }
}
