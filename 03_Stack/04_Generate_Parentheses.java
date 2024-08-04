class Solution {

    void genSequence(List<String> ans, String currString, int open, int closed, int n, String currPar) {
        currString += currPar;
        if (currPar.equals("("))
            open++;
        else
            closed++;

        if (open == n && closed == n) {
            ans.add(currString.toString());
            return;
        }

        if (open < n)
            genSequence(ans, currString, open, closed, n, "(");
        if (closed < open)
            genSequence(ans, currString, open, closed, n, ")");
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String currString = "";
        genSequence(ans, currString, 0, 0, n, "(");
        return ans;
    }
}