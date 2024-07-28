class Solution
{
public:
    bool isAnagram(string s, string t)
    {

        vector<int> count(26);

        int m = s.length(), n = t.length();

        if (m != n)
            return false;

        for (int i = 0; i < n; i++)
        {
            count[s[i] - 'a']++;
            count[t[i] - 'a']--;
        }

        for (int x : count)
            if (x != 0)
                return false;
        return true;
    }
};