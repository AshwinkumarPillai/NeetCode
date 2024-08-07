// TIME - O(n) : Two pass solution
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, prefix = 1, postfix = 1;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= postfix;
            postfix *= nums[i];
        }

        return ans;
    }
}