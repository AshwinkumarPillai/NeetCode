class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        
        st = []
        ans = [0] * len(temperatures)

        for index, temp in enumerate(temperatures):
            while len(st) > 0 and st[-1][0] < temp:
                ans[st[-1][1]] = index - st[-1][1]
                st.pop()
            st.append([temp, index])
        
        return ans
