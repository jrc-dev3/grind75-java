import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<String, Integer> letterCount = new HashMap<String, Integer>();


        for(String ch: magazine.split("")){
            if(!letterCount.containsKey(ch))
                letterCount.put(ch, 0);

            int newVal = letterCount.get(ch) + 1;
            letterCount.put(ch, newVal);
        }

        for(String letter: ransomNote.split("")){
            if(!letterCount.containsKey(letter))
                return false;

            if (letterCount.get(letter).equals(0))
                return false;
            
            int newVal = letterCount.get(letter) - 1;
            letterCount.put(letter, newVal);
            
        }
    
        return true;
            
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.canConstruct("aa", "aab");
        System.out.println(ans);
    }
}