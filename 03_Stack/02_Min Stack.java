class MinStack {

    List<Integer> st;
    List<Integer> minVals;

    public MinStack() {
        st = new ArrayList<>();
        minVals = new ArrayList<>();
    }

    public void push(int val) {
        st.add(val);
        if (minVals.isEmpty() || val <= minVals.get(minVals.size() - 1))
            minVals.add(val);
    }

    public void pop() {
        int top = st.remove(st.size() - 1);
        if (minVals.get(minVals.size() - 1) == top)
            minVals.remove(minVals.size() - 1);
    }

    public int top() {
        return st.get(st.size() - 1);
    }

    public int getMin() {
        return minVals.get(minVals.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */