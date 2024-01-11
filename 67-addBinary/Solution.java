import java.util.Arrays;

class Solution {
    public String addBinary(String a, String b) {

        int longestSringLen = Math.max(a.length(), b.length());
        int zeroesToAppend = Math.abs(a.length() - b.length());

        String[] frontZeroes = new String[zeroesToAppend];
        Arrays.fill(frontZeroes, "0");
        String zeroString = String.join("", frontZeroes);

        a = (a.length() == longestSringLen ? "" : zeroString) + a;
        b = (b.length() == longestSringLen ? "" : zeroString) + b;


        String[] aArr = a.split("");
        String[] bArr = b.split("");

        String[] newBinary = new String[longestSringLen];

        int remainder = 0;

        for (int i = aArr.length - 1; i >= 0; i--) {
            
            int aInt = Integer.parseInt(aArr[i]);
            int bInt = Integer.parseInt(bArr[i]);

            int absum = aInt + bInt + remainder;
            remainder = 0;


            if(absum == 2){
                absum = 0;
                remainder = 1;
            }

            if(absum == 3){
                absum = 1;
                remainder = 1;
            }
        
            newBinary[i] = String.valueOf(absum);
            
        }

        if(remainder == 1)
            return "1" + String.join("", newBinary);

        return String.join("", newBinary);
        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String ans = sol.addBinary("11", "1");
        System.out.println(ans);
    }
}