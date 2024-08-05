class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;

            // MID IS IN 'LEFT' SORTED PORTION
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l])
                    l = mid + 1;
                // target < nums[mid] || target > nums[l]
                else
                    r = mid - 1;
            }
            // MID IS IN 'RIGHT' SORTED PORTION
            else {
                if (target < nums[mid] || target > nums[r])
                    r = mid - 1;
                // target > nums[mid] or target < nums[r]
                else
                    l = mid + 1;
            }
        }

        return -1;
    }
}