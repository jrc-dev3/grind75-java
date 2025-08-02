import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    // [1,3],[2,6],[8,10] -> [1,6][8,10]

    public void quickSortIntervals(int[][] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        ;

        int[] pivotInterval = arr[end - 1];
        int pivot = pivotInterval[0];
        int lptr = start;
        int rptr = end - 1;

        while (lptr < rptr) {
            while (arr[lptr][0] < pivot && lptr < rptr) {
                lptr++;
            }

            while (arr[rptr][0] >= pivot && lptr < rptr) {
                rptr--;
            }

            int[] tmp = arr[lptr];
            arr[lptr] = arr[rptr];
            arr[rptr] = tmp;
        }

        int[] tmp = arr[lptr];

        arr[lptr] = pivotInterval;
        arr[end - 1] = tmp;

        quickSortIntervals(arr, start, lptr);
        quickSortIntervals(arr, lptr + 1, end);

    }

    public int[][] merge(int[][] intervals) {

        ArrayList<int[]> result = new ArrayList<>();

        quickSortIntervals(intervals, 0, intervals.length);

        // for (int[] in : intervals) {
        //     System.out.println(Arrays.toString(in));
        // }
        result.add(intervals[0]);

        int i = 1;
        int j = 0;

        while (i < intervals.length) {

            int[] curr = intervals[i];
            int[] prev = result.get(j);

            // System.out.println("Comparing: " + Arrays.toString(prev) + " : " +  Arrays.toString(curr) );

            if (curr[0] <= prev[1]) {
                result.set(j, new int[] { prev[0], Math.max(curr[1], Math.max(prev[1], curr[1])) });

                // restart loop
                i++;
                // j = 0;
                continue;
            }

            result.add(curr);
            j++;
            i++;
        }

        return result.stream().toArray(int[][]::new);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] ans = sol.merge(new int[][] {
                { 4, 5 }, { 2, 4 }, { 4, 6 }, { 3, 4 }, { 0, 0 }, { 1, 1 }, { 3, 5 }, { 2, 2 }
        });

        System.out.println("########");

        for (int[] in : ans) {
            System.out.println(Arrays.toString(in));
        }

    }

}