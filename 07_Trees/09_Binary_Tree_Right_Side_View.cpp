class Solution
{
public:
    vector<int> rightSideView(TreeNode *root)
    {
        vector<int> ans;
        queue<TreeNode *> q;

        if (root)
        {
            q.push(root);
            ans.push_back(root->val);
        }

        while (!q.empty())
        {
            int sz = q.size();
            TreeNode *recent = NULL;
            while (sz--)
            {
                TreeNode *node = q.front();
                q.pop();
                if (node->left)
                {
                    q.push(node->left);
                    recent = node->left;
                }
                if (node->right)
                {
                    q.push(node->right);
                    recent = node->right;
                }
            }

            if (recent)
                ans.push_back(recent->val);
        }
        return ans;
    }
};