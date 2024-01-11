import java.util.Arrays;
import java.util.Stack;

class Solution {

    class MyQueue {

        Stack<Integer> qstack;
        Stack<Integer> q;

        public MyQueue() {

            qstack = new Stack<Integer>();
            q = new Stack<Integer>();

        }

        public void push(int x) {
            qstack.push(x);
            
        }

        public int pop() {
            while(qstack.size() != 0){
                q.push(qstack.pop());
            }
            
            int res = q.pop();

            while(q.size() != 0){
                qstack.push(q.pop());
            }

            return res;
            
        }

        public int peek() {
            while(qstack.size() != 0){
                q.push(qstack.pop());
            }
            
            int res = q.peek();

            while(q.size() != 0){
                qstack.push(q.pop());
            }

            return res;

        }

        public boolean empty() {
            return qstack.empty();

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        MyQueue myQueue = sol.new MyQueue();
        myQueue.push(1); // queue is: [1]
        System.out.println(myQueue.peek());
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());
        myQueue.peek(); // return 1
        System.out.println(myQueue.peek());
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
        System.out.println(myQueue.empty());
    }

}