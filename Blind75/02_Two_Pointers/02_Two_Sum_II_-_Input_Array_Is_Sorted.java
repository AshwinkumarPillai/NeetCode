class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int value = numbers[i] + numbers[j];

            if (value == target)
                return new int[] { i + 1, j + 1 };
            if (value < target)
                i++;
            if (value > target)
                j--;
        }

        return new int[0];
    }
}