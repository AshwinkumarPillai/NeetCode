class MinStack(object):

    def __init__(self):
        self.st = []
        self.minVals = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """

        self.st.append(val)
        if len(self.minVals) == 0 or val <= self.minVals[-1]:
            self.minVals.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        if self.minVals[-1] == self.st[-1]:
            self.minVals.pop()
        self.st.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.st[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minVals[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()