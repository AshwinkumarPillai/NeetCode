class Solution {

    int ans = 0;

    public void dfs(TreeNode root, int max) {
        if (root == null)
            return;
        if (root.val >= max) {
            ans++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
}