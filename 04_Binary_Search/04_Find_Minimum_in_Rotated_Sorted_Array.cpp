// EXPLANATION SOLUTION FROM LEETCODE
// https:///leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/158940/beat-100-very-simple-python-very-detailed-explanation/

class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int n = nums.size();
        int l = 0, r = n - 1;

        while (l < r)
        {
            int mid = l + (r - l) / 2;
            int x = nums[mid];

            if (x > nums[r])
                l = mid + 1;
            else
                r = mid;
        }

        return nums[l];
    }
};

// Binary Search: Standard Solution
class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int n = nums.size();
        int l = 0, r = n - 1;

        int ans = INT_MAX;

        while (l < r)
        {
            int mid = l + (r - l) / 2;
            int x = nums[mid];

            ans = min(ans, x);

            if (x > nums[r])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return min(ans, nums[l]);
    }
};

// Solution with Extra checks (faster than first but prefer to use first one)
class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int n = nums.size();
        int l = 0, r = n - 1;

        if (n == 1 || nums[0] < nums[n - 1])
            return nums[0];
        if (n == 2)
            return min(nums[0], nums[1]);

        while (l < r)
        {
            int mid = l + (r - l) / 2;
            int x = nums[mid];

            if (x > nums[mid + 1])
                return nums[mid + 1];
            if (x < nums[mid - 1])
                return nums[mid];

            if (x > nums[r])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return nums[0];
    }
};