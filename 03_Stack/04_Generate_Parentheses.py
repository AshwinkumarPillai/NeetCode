class Solution(object):
    
    def genSequence(self, ans, currString, openCount, closed, n, currPar):
        currString += currPar
        if currPar == "(":
            openCount += 1
        else:
            closed += 1
        
        if openCount == n and closed == n:
            ans.append(currString)
        
        if openCount < n:
            self.genSequence(ans, currString, openCount, closed, n, "(")
        if closed < openCount:
            self.genSequence(ans, currString, openCount, closed, n, ")")
    
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        currString = ""

        self.genSequence(ans, currString, 0, 0, n, "(")
        return ans


# STACK BASED SOLUTION:
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        res = []

        def backtrack(openN, closedN):
            if openN == closedN == n:
                res.append("".join(stack))
                return

            if openN < n:
                stack.append("(")
                backtrack(openN + 1, closedN)
                stack.pop()
            if closedN < openN:
                stack.append(")")
                backtrack(openN, closedN + 1)
                stack.pop()

        backtrack(0, 0)
        return res
