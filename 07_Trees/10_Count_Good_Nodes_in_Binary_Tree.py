class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        
        self.ans = 0

        def dfs(root, maxVal):
            if not root:
                return
            if root.val >= maxVal:
                maxVal = root.val
                self.ans += 1
            
            dfs(root.left, maxVal)
            dfs(root.right, maxVal)
        
        dfs(root, root.val)
        return self.ans