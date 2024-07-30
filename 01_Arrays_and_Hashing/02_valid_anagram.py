class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        arr = [0] * 26
        if len(s) != len(t):
            return False
        
        for i in range(len(s)):
            arr[ord(s[i]) - ord('a')] += 1
            arr[ord(t[i]) - ord('a')] -= 1
        
        for x in arr:
            if x != 0:
                return False
        return True