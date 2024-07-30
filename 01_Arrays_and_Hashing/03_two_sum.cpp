class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        map<int, int> m;

        for (int i = 0; i < nums.size(); i++)
        {
            int val = target - nums[i];

            if (m.find(val) != m.end())
            {
                return {i, m[val]};
            }
            else
            {
                m[nums[i]] = i;
            }
        }
        return {};
    }
};