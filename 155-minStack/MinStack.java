import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minTracker;

    public MinStack() {
        stack = new ArrayDeque<>();
        minTracker = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.add(val);
        
        if(minTracker.isEmpty()){
            minTracker.add(val);
            return;
        }
       
        minTracker.add(Math.min(val, minTracker.peekLast()));
    }
    
    public void pop() {
        stack.pollLast();
        minTracker.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
        
    }
    
    public int getMin() {
        return minTracker.peekLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.err.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
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