class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        left, right = 1, max(piles)
        ans = right

        while left <= right:
            mid = (left + right) // 2
            hours = 0
            for pile in piles:
                hours += math.ceil(float(pile)/mid)
            
            if hours <= h:
                right = mid - 1
                ans = min(ans, mid)
            else:
                left = mid + 1
        
        return ans