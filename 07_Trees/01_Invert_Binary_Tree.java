/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// BFS SOLUTION
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);

        while (q.size() > 0) {
            TreeNode node = q.remove();
            TreeNode temp = node.left;
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }
}

// RECURSIVE SOLUTION
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);

        root.left = left;
        root.right = right;

        return root;
    }
}