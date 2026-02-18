package treesandgraphs.trees;

/**
 * Height of a Binary Tree
 * Problem Statement:
 * Given the root of a binary tree, find the height (maximum depth) of the tree.
 * Input: Root of a binary tree
 * Output: Integer representing height
 * Concepts Tested: Recursion, Tree traversal
 */
public class HeightOfBinaryTree {

    /**
     * Calculates the height (maximum depth) of the binary tree.
     * Use recursion to traverse down the tree.
     *
     * @param root The root of the binary tree.
     * @return The height of the tree.
     */
    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0; // Height of an empty tree is 0
        }

        // Recursively find the height of the left and right subtrees
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Height is max of left and right subtree height + 1 (for the root)
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

        System.out.println("Height of tree: " + findHeight(root)); // Expected: 3
    }
}
