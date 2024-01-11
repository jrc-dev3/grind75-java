import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if(memo.containsKey(n))
            return memo.get(n);
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
            
        
        int ways = climbStairs(n-1) + climbStairs(n-2);
        memo.put(n, ways);
        return ways;
        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.climbStairs(44);
        System.out.println(ans);
    }
}