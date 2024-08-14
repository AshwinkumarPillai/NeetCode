class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = []
        ans = []

        if root:
            q.append(root)
            ans.append(root.val)
        
        while len(q) > 0:
            sz = len(q)
            recent = None

            while sz > 0:
                node = q[0]
                if node.left:
                    q.append(node.left)
                    recent = node.left
                if node.right:
                    q.append(node.right)
                    recent = node.right
                q.pop(0)
                sz -= 1

            if recent is not None:
                ans.append(recent.val)

        return ans