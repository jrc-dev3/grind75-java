import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        boolean isEven = s.length() % 2 == 0 ? true : false;
        boolean containsAnOddCountLetter = false;

        Map<String, Integer> letterCount = new HashMap<>();

        for(String ch: s.split("")){
            if(!letterCount.containsKey(ch))
                letterCount.put(ch, 0);

            letterCount.put(ch, letterCount.get(ch) + 1);
        }

        if(letterCount.size() == 1){
            String letter = s.substring(0,1);
            int amount = letterCount.get(letter);
            return amount;
        }

        int longestLength = 0;

        for(Integer n: letterCount.values()){
            int remainder = n % 2;
            if(remainder == 0){
                longestLength += n;
                continue;
            }

            containsAnOddCountLetter = true;
            longestLength += (n - remainder);
        }

        if(letterCount.values().contains(1))
            return longestLength + 1;

        if(!isEven && containsAnOddCountLetter)
            return longestLength + 1;

        if(!containsAnOddCountLetter)
            return longestLength;

        return longestLength + 1;
        
    }
}