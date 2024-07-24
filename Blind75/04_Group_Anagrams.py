class Solution(object):
    
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        
        m = defaultdict(list)

        for s in strs:

            bitMap = [0] * 26

            for x in s:
                bitMap[ord(x) - ord('a')] += 1

            m[tuple(bitMap)].append(s)

        return m.values()