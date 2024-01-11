/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution {

    private boolean isBadVersion(int n){

        boolean res = (long)n >= 1702766719 ? true: false;
        return res;
    }

    private long binarySearch(long s, long e){
        if(s == e)
            return s;

        long m = Math.floorDiv(s+e, 2);

        if(isBadVersion((int)m)){


            long numBefore = m - 1;

            if(isBadVersion((int)numBefore))
                return binarySearch(s, m-1);
            
            return m;
        }

       
        return binarySearch(m+1, e);

    }

    public int firstBadVersion(int n) {

        long ans = binarySearch(1, n);
        return (int)ans;
  
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.firstBadVersion(2126753390);
        System.out.println(ans);
        
    }
}