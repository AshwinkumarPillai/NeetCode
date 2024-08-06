
class TimeMap
{
public:
    map<string, vector<pair<string, int>>> m;

    TimeMap()
    {
    }

    void set(string key, string value, int timestamp)
    {
        m[key].push_back({value, timestamp});
    }

    string get(string key, int timestamp)
    {
        string ans = "";

        int l = 0, r = m[key].size() - 1;

        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            int val = m[key][mid].second;

            if (val == timestamp)
                return m[key][mid].first;
            if (val < timestamp)
            {
                ans = m[key][mid].first;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return ans;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */