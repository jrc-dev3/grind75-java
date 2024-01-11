import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {


    HashMap<String, String> pairs = new HashMap<String, String>(){{
      put("{", "}");
      put("[", "]");
      put("(", ")");
    }};


    public boolean isValid(String s) {

        Deque<String> stack = new ArrayDeque<String>(){};

        for(String c: s.split("")){

          if(stack.size() == 0) {
            stack.add(c);
          }else{
            String lookingFor = pairs.get(stack.getLast());

            if ( c.equals(lookingFor) ) {
              stack.pollLast();
            }else{
              stack.add(c);
            }
          }

        }

        return stack.size() == 0 ? true : false;

        
    }


    public static void main(String[] args) {

      Solution sol = new Solution();
      boolean ans = sol.isValid("()");
      System.out.println(ans);

    }
}