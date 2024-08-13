/**
 * Definition for a binary tree node.
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode() : val(0), left(nullptr), right(nullptr) {}
 * TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 * TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */

class Solution
{
public:
    int dfs(TreeNode *root)
    {
        if (!root)
            return 0;
        int left = dfs(root->left);
        int right = dfs(root->right);
        if (left == -1 || right == -1 || abs(left - right) > 1)
            return -1;
        return max(left, right) + 1;
    }

    bool isBalanced(TreeNode *root)
    {
        return dfs(root) != -1;
    }
};

class Solution
{
public:
    pair<int, bool> checkSubtreeDepth(TreeNode *root)
    {
        if (!root)
            return {0, true};
        auto left = checkSubtreeDepth(root->left);
        auto right = checkSubtreeDepth(root->right);
        if (!left.second || !right.second)
            return {-1, false};
        if (abs(left.first - right.first) > 1)
            return {-1, false};
        return {max(left.first, right.first) + 1, true};
    }

    bool isBalanced(TreeNode *root)
    {
        return checkSubtreeDepth(root).second;
    }
};