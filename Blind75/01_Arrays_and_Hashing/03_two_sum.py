class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        m = {}

        for index, val in enumerate(nums):
            if (target - val) in m.keys():
                return [index, m[target-val]]
            else:
                m[val] = index

        return []