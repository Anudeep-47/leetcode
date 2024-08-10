class MyQueue {
    stack<int> in_stack {}, out_stack {};
    int size {};
private:
    void move_to_out() {
        while (!in_stack.empty()) {
            out_stack.push(in_stack.top());
            in_stack.pop();
        }
    }
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        in_stack.push(x);
        size++;
    }
    
    int pop() {
        int top { peek() };
        out_stack.pop();
        size--;
        return top;
    }
    
    int peek() {
        if (out_stack.empty()) move_to_out();
        return out_stack.top();
    }
    
    bool empty() {
        return in_stack.empty() && out_stack.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */