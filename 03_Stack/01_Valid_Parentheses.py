class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        stack = []
        m = {
            '}': '{',
            ']': '[',
            ')': '(',
        }

        for x in s:
            if x == '(' or x == '{' or x == '[':
                stack.append(x)
            elif len(stack) == 0 or stack[-1] != m[x]:
                return False
            else:
                stack.pop()
        
        return len(stack) == 0