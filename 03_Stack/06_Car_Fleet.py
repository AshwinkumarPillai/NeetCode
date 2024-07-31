# TIME - O(nlogn) + O(n) [Sort + Single Pass]class Solution(object):
    def carFleet(self, target, position, speed):
        """
        :type target: int
        :type position: List[int]
        :type speed: List[int]
        :rtype: int
        """
        stack = []
        arr = [[pos , sp] for pos, sp in zip(position, speed)]

        for pos, sp in sorted(arr)[::-1]:
            currTime = float(target - pos) / float(sp)
            if len(stack) == 0 or currTime > stack[-1]:
                stack.append(currTime)
        
        return len(stack)