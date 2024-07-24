class Solution(object):
    
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        
        m = {}

        for s in strs:
            key = ''.join(sorted(s))
            
            if key in m.keys():
                m[key].append(s)
            else:
                m[key] = [s]
        
        ans = [val for _, val in m.items()]
        return ans