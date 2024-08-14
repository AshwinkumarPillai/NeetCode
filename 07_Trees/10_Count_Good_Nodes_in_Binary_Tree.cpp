class Solution
{
public:
    int ans;

    void dfs(TreeNode *root, int maxVal)
    {
        if (!root)
            return;
        if (root->val >= maxVal)
        {
            ans++;
            maxVal = root->val;
        }
        dfs(root->left, maxVal);
        dfs(root->right, maxVal);
    }

    int goodNodes(TreeNode *root)
    {
        dfs(root, root->val);
        return ans;
    }
};