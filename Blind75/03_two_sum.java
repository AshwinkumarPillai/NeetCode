class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (m.containsKey(val)) {
                return new int[] { i, m.get(val) };
            } else {
                m.put(nums[i], i);
            }
        }

        return new int[0];
    }
}