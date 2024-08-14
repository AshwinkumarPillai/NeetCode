class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
            ans.add(root.val);
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            TreeNode recent = null;

            while (sz > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    recent = node.left;
                }
                if (node.right != null) {
                    q.add(node.right);
                    recent = node.right;
                }
                sz--;
            }
            if (recent != null)
                ans.add(recent.val);
        }
        return ans;
    }
}