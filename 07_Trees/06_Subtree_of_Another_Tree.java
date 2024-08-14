class Solution {

    public boolean isSame(TreeNode node, TreeNode target) {
        if (node == null || target == null)
            return node == target;
        if (node.val != target.val)
            return false;

        return isSame(node.left, target.left) && isSame(node.right, target.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (isSame(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}