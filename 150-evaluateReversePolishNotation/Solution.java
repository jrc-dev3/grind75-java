import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stringStack = new Stack<>();

        int a, b;

        for(String entry: tokens){

            switch (entry) {
                case "+":
                    b = stringStack.pop();
                    a = stringStack.pop();
                    stringStack.add(a+b);
                    break;
                case "-":
                    b = stringStack.pop();
                    a = stringStack.pop();
                    stringStack.add(a-b);
                    break;
                case "/":
                    b = stringStack.pop();
                    a = stringStack.pop();
                    stringStack.add(a/b);
                    break;
                case "*":
                    b = stringStack.pop();
                    a = stringStack.pop();
                    stringStack.add(a*b);
                    break;
                default:
                    int num = Integer.valueOf(entry);
                    stringStack.add(num);
                    break;
            }

        }

        return stringStack.pop();
        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int ans = sol.evalRPN(new String[]{"2","1","+","3","*"});
        int ans = sol.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(ans);
    }
}