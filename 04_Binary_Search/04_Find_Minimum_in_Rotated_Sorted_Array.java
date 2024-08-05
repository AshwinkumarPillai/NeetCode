// Wihout checking smallest everytime 
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid; // -> set the right to the mid
        }

        return nums[l];
    }
}

// EXPLANATION SOLUTION FROM LEETCODE
// https:///leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/158940/beat-100-very-simple-python-very-detailed-explanation/

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, ans = Integer.MAX_VALUE;

        while (l < r) {
            int mid = l + (r - l) / 2;
            ans = Math.min(ans, nums[mid]);

            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return Math.min(ans, nums[l]);
    }
}
