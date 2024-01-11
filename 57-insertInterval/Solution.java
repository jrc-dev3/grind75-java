import java.util.ArrayList;

class Solution {

    private int[][] convertToArray(ArrayList<int[]> arr){

        int[][] res = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]){
                ans.add(newInterval);
                newInterval = intervals[i];
        
            }else if(newInterval[0] > intervals[i][1] ){
                ans.add(intervals[i]);
            }else{
                newInterval = new int[]{
                    Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1])
                };
            }
        }

        ans.add(newInterval);
        int[][] res = convertToArray(ans);
        return res;
      
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.insert(new int[][] {
        //         { 1, 2 },
        //         { 3, 5 },
        //         { 6, 7 },
        //         { 8, 10 },
        //         { 12, 16 }
        // }, new int[] { 4, 8 });

        sol.insert(new int[][] {
                { 0, 5 },
                { 9, 12 },
        }, new int[] { 7, 16 });
    }
}