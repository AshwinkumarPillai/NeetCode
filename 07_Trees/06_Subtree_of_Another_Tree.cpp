class Solution
{
public:
    bool isSame(TreeNode *node, TreeNode *target)
    {
        if (!node || !target)
            return node == target;
        if (node->val != target->val)
            return false;
        return isSame(node->left, target->left) && isSame(node->right, target->right);
    }

    bool isSubtree(TreeNode *root, TreeNode *subRoot)
    {
        if (!root)
            return false;
        if (isSame(root, subRoot))
            return true;
        return isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
};