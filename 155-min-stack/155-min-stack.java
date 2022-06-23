class MinStack {
    private Stack<Integer> stk = new Stack<>();
    private Stack<int[]> minStk = new Stack<>();
    
    public MinStack() {
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.empty() || val < minStk.peek()[0]){
            minStk.push(new int[]{val, 1});
        }
        else if(val == minStk.peek()[0]){
            minStk.peek()[1]++;
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(minStk.peek()[0] == val){
            minStk.peek()[1]--;
            if(minStk.peek()[1] == 0){
                minStk.pop();
            }
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek()[0];
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