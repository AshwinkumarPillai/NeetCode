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

class Solution {

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
}

class Solution {

    public Pair<Integer, Boolean> dfs(TreeNode node) {
        if (node == null)
            return new Pair<Integer, Boolean>(0, true);
        Pair<Integer, Boolean> left = dfs(node.left);
        Pair<Integer, Boolean> right = dfs(node.right);

        if (!left.getValue() || !right.getValue())
            return new Pair<>(-1, false);
        if (Math.abs(left.getKey() - right.getKey()) > 1)
            return new Pair<>(-1, false);
        return new Pair<>(Math.max(left.getKey(), right.getKey()) + 1, true);
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).getValue();
    }
}