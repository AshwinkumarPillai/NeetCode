// TIME: O(m*n) solution
class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        map<string, vector<string>> m;

        for (string s : strs)
        {
            vector<int> bitMap(26);

            for (char x : s)
            {
                bitMap[x - 'a']++;
            }

            string key = "";
            for (int x : bitMap)
            {
                key += to_string(x) + '#';
            }

            m[key].push_back(s);
        }

        vector<vector<string>> ans;

        for (auto p : m)
        {
            ans.emplace_back(p.second);
        }

        return ans;
    }
};

// TIME: O(m*nlogn) solution
class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        map<string, vector<string>> m;

        for (string s : strs)
        {
            vector<int> bitMap(26);

            for (char x : s)
            {
                bitMap[x - 'a']++;
            }

            string key = "";
            for (int x : bitMap)
            {
                key += to_string(x) + '#';
            }

            m[key].push_back(s);
        }

        vector<vector<string>> ans;

        for (auto p : m)
        {
            ans.emplace_back(p.second);
        }

        return ans;
    }
};