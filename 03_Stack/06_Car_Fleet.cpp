// TIME - O(nlogn) + O(n) [Sort + Single Pass]
class Solution
{
public:
    static bool compare(pair<int, int> &a, pair<int, int> &b)
    {
        return a.first > b.first;
    }

    int carFleet(int target, vector<int> &position, vector<int> &speed)
    {
        stack<float> st;
        vector<pair<int, int>> arr;

        int n = position.size();

        for (int i = 0; i < n; i++)
        {
            arr.push_back({position[i], speed[i]});
        }

        // WE can also use  sort(arr.rbegin(), arr.rend()); -> this will reverse sort without compare function
        sort(arr.begin(), arr.end(), compare);

        for (auto p : arr)
        {
            // float currTime = static_cast<float>(target - p.first) / p.second; ->  Better way to do it
            float currTime = float(target - p.first) / float(p.second);

            if (st.empty() || currTime > st.top())
                st.push(currTime);
        }

        return st.size();
    }
};