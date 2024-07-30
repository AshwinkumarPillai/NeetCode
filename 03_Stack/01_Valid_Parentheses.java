class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> m = new HashMap<>();

        m.put('}', '{');
        m.put(']', '[');
        m.put(')', '(');

        for (char x : s.toCharArray()) {
            if (x == '{' || x == '[' || x == '(')
                st.push(x);
            else if (st.isEmpty() || st.peek() != m.get(x))
                return false;
            else
                st.pop();
        }

        return st.isEmpty();
    }
}