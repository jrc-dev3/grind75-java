import java.util.Stack;

class Solution {
    public boolean isPalindrome(String s) {

      Stack<String> stack = new Stack<String>();

      String filteredString = "";
      for (int i = s.length() - 1; i >= 0; i--) {
        char currChar = s.charAt(i);
        if(Character.isLetterOrDigit(currChar)) {
          String c = s.substring(i, i+1).toLowerCase();
          filteredString += c;
          stack.add(c);        
        }

      }

      for (int i = 0; i < filteredString.length(); i++) {

        String currChar = filteredString.substring(i, i+1);
        String onTopOfStack = stack.peek();
        if(!currChar.equals(onTopOfStack)) return false;
        
        stack.pop();
        
      }

      boolean ans = stack.size() == 0 ? true : false;
      return ans;
       
    }

    public static void main(String[] args) {
      Solution sol = new Solution();
      sol.isPalindrome("race a car");
    }
}