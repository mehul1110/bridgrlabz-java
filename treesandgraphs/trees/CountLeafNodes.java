package treesandgraphs.trees;

/**
 * Count Leaf Nodes
 * Problem Statement:
 * Given a binary tree, count the number of leaf nodes (nodes with no children).
 * Input: Root of the tree
 * Output: Number of leaf nodes
 * Concepts Tested: Tree traversal, Base condition handling
 */
public class CountLeafNodes {

    /**
     * Counts the number of leaf nodes in a binary tree.
     * Leaf nodes are nodes with no children.
     *
     * @param root The root of the binary tree.
     * @return The number of leaf nodes.
     */
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0; // Base case: Empty tree has no leaves
        }

        // If it's a leaf node (no children), count it as 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Recursively count leaves in subtrees
        return countLeaves(root.left) + countLeaves(root.right);
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

        System.out.println("Number of leaf nodes: " + countLeaves(root)); // Expected: 3 (4, 5, 3)
    }
}
