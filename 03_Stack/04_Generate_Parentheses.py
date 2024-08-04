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