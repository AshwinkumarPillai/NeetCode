class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = []
        ans = []

        if root:
            q.append(root)
        
        while len(q) > 0:
            sz = len(q)
            temp = []
            while sz > 0:
                node = q[0]
                temp.append(q[0].val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                q.pop(0)
                sz -= 1
            ans.append(temp)

        return ans