class Solution {

    public boolean dfs(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val <= minVal || root.val >= maxVal)
            return false;
        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        long minVal = Integer.MIN_VALUE, maxVal = Integer.MAX_VALUE;
        minVal--;
        maxVal++;
        return dfs(root, minVal, maxVal);
    }
}