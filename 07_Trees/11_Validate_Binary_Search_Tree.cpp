class Solution
{
public:
    bool dfs(TreeNode *root, long minVal, long maxVal)
    {
        if (!root)
            return true;
        if (root->val <= minVal || root->val >= maxVal)
            return false;
        return dfs(root->left, minVal, root->val) && dfs(root->right, root->val, maxVal);
    }

    bool isValidBST(TreeNode *root)
    {
        long minVal = INT_MIN, maxVal = INT_MAX;
        minVal--;
        maxVal++;

        return dfs(root, minVal, maxVal);
    }
};