// TIME - O(n) - BUCKET-SORT
class Solution
{
public:
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        map<int, int> m;
        for (int x : nums)
            m[x]++;
        vector<vector<int>> bucket(nums.size() + 1);

        for (auto p : m)
        {
            bucket[p.second].emplace_back(p.first);
        }

        vector<int> ans;

        for (int i = bucket.size() - 1; i >= 0; i--)
        {
            for (int x : bucket[i])
            {
                ans.emplace_back(x);
                if (ans.size() == k)
                    return ans;
            }
        }

        return ans;
    }
};

// Time - O(klogn) - HEAP
class Solution
{
public:
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        map<int, int> m;
        for (int x : nums)
            m[x]++;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;

        for (auto p : m)
        {
            minHeap.push({p.second, p.first});
            if (minHeap.size() > k)
                minHeap.pop(); // keep only the K largest elements
        }

        vector<int> ans;
        while (!minHeap.empty())
        {
            ans.emplace_back(minHeap.top().second);
            minHeap.pop();
        }

        return ans;
    }
};

// TIME - O(nlogn)
class Solution
{
public:
    static bool compare(pair<int, int> a, pair<int, int> b)
    {
        return a.second > b.second;
    }

    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        map<int, int> m;
        for (int x : nums)
            m[x]++;
        vector<pair<int, int>> pairs(m.begin(), m.end());
        sort(pairs.begin(), pairs.end(), compare);
        vector<int> ans;
        for (int i = 0; i < k; i++)
            ans.push_back(pairs[i].first);
        return ans;
    }
};