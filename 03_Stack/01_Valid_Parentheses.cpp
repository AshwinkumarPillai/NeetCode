class Solution
{
public:
    bool isValid(string s)
    {
        stack<int> st;
        map<char, char> m;
        m['}'] = '{';
        m[']'] = '[';
        m[')'] = '(';

        for (char x : s)
        {
            if (x == '(' || x == '{' || x == '[')
                st.push(x);
            else if (x == ')' || x == '}' || x == ']')
            {
                if (st.empty() || st.top() != m[x])
                    return false;
                st.pop();
            }
        }
        return st.empty();
    }
};