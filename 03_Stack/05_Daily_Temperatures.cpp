class Solution
{
public:
    vector<int> dailyTemperatures(vector<int> &temperatures)
    {
        stack<pair<int, int>> st; // <temp, index>
        vector<int> ans(temperatures.size());

        for (int i = 0; i < temperatures.size(); i++)
        {
            int temp = temperatures[i];
            while (!st.empty() && st.top().first < temp)
            {
                ans[st.top().second] = i - st.top().second;
                st.pop();
            }
            st.push({temp, i});
        }

        return ans;
    }
};