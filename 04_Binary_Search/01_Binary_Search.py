class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            val = nums[mid]
            if val == target:
                return mid
            elif val < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1