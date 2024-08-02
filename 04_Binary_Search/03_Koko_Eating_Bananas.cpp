class Solution
{
public:
    int minEatingSpeed(vector<int> &piles, int h)
    {
        int left = 1, right = *max_element(piles.begin(), piles.end());
        int ans = right;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int64_t hours = 0;

            for (int pile : piles)
                hours += (pile + mid - 1) / mid;

            if (hours <= h)
            {
                right = mid - 1;
                ans = min(ans, mid);
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
    }
};