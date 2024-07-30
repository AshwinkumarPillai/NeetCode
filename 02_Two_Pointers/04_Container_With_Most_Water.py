class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        ans, i, j = 0, 0, len(height) - 1

        while i < j:
            ans = max(ans, min(height[i], height[j]) * (j-i))
            if height[i] < height[j]:
                i += 1
            elif height[i] > height[j]:
                j -= 1
            else:
                i += 1
                j -= 1
                
        return ans
        