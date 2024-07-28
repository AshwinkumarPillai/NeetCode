class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        i = 0
        j = len(numbers) - 1

        while i < j:
            val = numbers[i] + numbers[j]
            if val == target:
                return [i+1,j+1]
            if val < target:
                i += 1
            elif val > target:
                j -= 1
        
        return []