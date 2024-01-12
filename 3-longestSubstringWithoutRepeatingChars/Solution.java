import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> indexMap = new HashMap<>();
        Set<Character> letterSet = new HashSet<>();
        char[] letters = s.toCharArray();
        Integer mx = Integer.MIN_VALUE;

        int i = 0;
        int oob = s.length();

        while (i < oob) {
            Character ch = letters[i];

            if (letterSet.contains(ch)) {
                mx = Math.max(mx, letterSet.size());
                letterSet.clear();
                i = indexMap.get(ch) + 1;
                indexMap.clear();
                letterSet.add(letters[i]);
                indexMap.put(letters[i], i);

            } else {
                letterSet.add(ch);
                indexMap.put(ch, i);
            }

            i++;

        }

        mx = Math.max(mx, letterSet.size());

        return mx;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // int ans = sol.lengthOfLongestSubstring("dvdf");
        int ans = sol.lengthOfLongestSubstring("abba");
        // int ans = sol.lengthOfLongestSubstring("zabacb");
        // int ans = sol.lengthOfLongestSubstring("abcabacbb");
        System.out.println(ans);
    }
}