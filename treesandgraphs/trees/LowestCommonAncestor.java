package treesandgraphs.trees;

/**
 * Lowest Common Ancestor (LCA) of a Binary Tree
 * Problem Statement:
 * Given a binary tree and two nodes p and q, find their lowest common ancestor.
 * Concepts Tested: Recursion, Tree traversal logic
 */
public class LowestCommonAncestor {

    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a binary tree.
     * The LCA is defined between two nodes p and q as the lowest node in T that has
     * both p and q as descendants
     * (where we allow a node to be a descendant of itself).
     *
     * @param root The root of the binary tree.
     * @param p    One of the nodes.
     * @param q    The other node.
     * @return The LCA of p and q.
     */
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If root is null, or root is one of the nodes, then root is the LCA
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode leftLCA = findLCA(root.left, p, q);
        TreeNode rightLCA = findLCA(root.right, p, q);

        // If both left and right returned non-null, it means p and q are in different
        // subtrees, so root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise return the non-null child (if both are null, returns null)
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        // Construct a sample tree:
        // 3
        // / \
        // 5 1
        // / \ / \
        // 6 2 0 8
        // / \
        // 7 4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node 5
        TreeNode q = root.left.right.right; // Node 4

        TreeNode lca = findLCA(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + ": " + (lca != null ? lca.val : "null")); // Expected:
                                                                                                           // 5 (since 5
                                                                                                           // is
                                                                                                           // ancestor
                                                                                                           // of 4)

        TreeNode p2 = root.left.left; // Node 6
        TreeNode q2 = root.left.right; // Node 2
        TreeNode lca2 = findLCA(root, p2, q2);
        System.out.println("LCA of " + p2.val + " and " + q2.val + ": " + (lca2 != null ? lca2.val : "null")); // Expected:
                                                                                                               // 5
    }
}
