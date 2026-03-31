class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
   

    public MinStack() {

    }

    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            if(val <= minStack.peek()){
                minStack.push(val);
            }
        }
    }

    public void pop() {
       int temp = st.peek();
       st.pop();
       if(temp == minStack.peek())
        minStack.pop();
    }

    public int top() {
       return st.peek();
    }

    public int getMin() {
        return minStack.peek();
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