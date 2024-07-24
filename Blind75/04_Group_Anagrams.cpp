class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        map<string, vector<string>> m;

        for (string s : strs)
        {
            string key = s;
            sort(key.begin(), key.end());
            m[key].emplace_back(s);
        }

        vector<vector<string>> ans;

        for (auto p : m)
        {
            ans.emplace_back(p.second);
        }

        return ans;
    }
};