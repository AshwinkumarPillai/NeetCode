class Solution
{
public:
    int evalRPN(vector<string> &tokens)
    {
        unordered_map<string, function<int(int, int)>> m = {
            {"+", [](int a, int b)
             { return a + b; }},
            {"-", [](int a, int b)
             { return a - b; }},
            {"*", [](int a, int b)
             { return a * b; }},
            {"/", [](int a, int b)
             { return a / b; }}};

        stack<int> st;

        for (string &s : tokens)
        {
            if (!m.count(s))
                st.push(stoi(s));
            else
            {
                int op1 = st.top();
                st.pop();
                int op2 = st.top();
                st.pop();
                st.push(m[s](op2, op1));
            }
        }
        return st.top();
    }
};