class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> st = new Stack<>();
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            arr.add(new int[] { position[i], speed[i] });
        }

        Collections.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] pair : arr) {
            float currTime = (float) (target - pair[0]) / pair[1];
            if (st.isEmpty() || currTime > st.peek())
                st.push(currTime);
        }

        return st.size();
    }
}