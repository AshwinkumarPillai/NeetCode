class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();

            while (sz > 0) {
                TreeNode node = q.poll();
                temp.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                sz--;
            }
            ans.add(temp);
        }
        return ans;
    }
}