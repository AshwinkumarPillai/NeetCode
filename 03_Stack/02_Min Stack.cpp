class MinStack
{
public:
    vector<int> st;
    vector<int> minVals;

    MinStack()
    {
    }

    void push(int val)
    {
        st.push_back(val);
        if (!minVals.size() || val <= minVals.back())
            minVals.push_back(val);
    }

    void pop()
    {
        if (st.back() == minVals.back())
            minVals.pop_back();
        st.pop_back();
    }

    int top()
    {
        return st.back();
    }

    int getMin()
    {
        return minVals.back();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */