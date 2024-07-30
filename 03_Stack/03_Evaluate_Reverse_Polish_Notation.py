class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """

        m = {
            '+': operator.add,
            '-': operator.sub,
            '*': operator.mul,
            '/': operator.truediv
        }

        st = []

        for s in tokens:
            if s not in m:
                st.append(int(s))
            else:
                op1 = st.pop()
                op2 = st.pop()
                st.append(int(m[s](op2, op1)))
        
        return st.pop()
                