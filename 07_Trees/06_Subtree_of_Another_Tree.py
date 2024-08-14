class Solution:

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        def isSame(node: Optional[TreeNode], target: Optional[TreeNode]):
            if node == None and target == None:
                return True
            if node == None or target == None:
                return False
            
            if node.val != target.val:
                return False
            
            return isSame(node.left, target.left) and isSame(node.right, target.right)
        
        if not root:
            return False

        if isSame(root, subRoot):
            return True
        
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)