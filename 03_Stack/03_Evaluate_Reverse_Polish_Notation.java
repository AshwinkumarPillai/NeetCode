class Solution {
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> m = new HashMap<>();

        m.put("+", (a, b) -> a + b);
        m.put("-", (a, b) -> a - b);
        m.put("*", (a, b) -> a * b);
        m.put("/", (a, b) -> a / b);

        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            if (!m.containsKey(s))
                st.push(Integer.parseInt(s));
            else {
                int op1 = st.pop();
                int op2 = st.pop();
                st.push(m.get(s).apply(op2, op1));
            }
        }

        return st.pop();
    }
}