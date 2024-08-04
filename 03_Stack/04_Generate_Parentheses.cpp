class Solution
{
public:
    void genSequence(vector<string> &ans, string currString, int open, int closed, int n, string currPar)
    {
        currString += currPar;
        if (currPar == "(")
            open++;
        else
            closed++;

        if (open == n && closed == n)
        {
            ans.push_back(currString);
            return;
        }

        if (open < n)
            genSequence(ans, currString, open, closed, n, "(");
        if (closed < open)
            genSequence(ans, currString, open, closed, n, ")");
    }

    vector<string> generateParenthesis(int n)
    {
        vector<string> ans;
        string currString = "";
        genSequence(ans, currString, 0, 0, n, "(");
        return ans;
    }
};