class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m , n = len(matrix), len(matrix[0])
        i, j = 0, n-1

        while i < m and j >= 0:
            x = matrix[i][j]
            if x == target:
                return True
            elif target > x:
                i += 1
            elif target < x:
                j -= 1
            else:
                return False
        
        return False
