class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<int[]> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!st.isEmpty() && st.peek()[0] < temp) {
                int[] top = st.pop();
                ans[top[1]] = i - top[1];
            }
            st.push(new int[] { temp, i });
        }

        return ans;
    }
}