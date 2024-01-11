import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private Double findDistanceFromOrigin(int[] coord){

        int y2 = coord[1];
        int x2 = coord[0];
        int y = 0;
        int x = 0;

        double inner = Math.pow((x-x2), 2) + Math.pow((y-y2), 2);
        double res = Math.sqrt(inner);

        return res;
    }

    public int[][] kClosest(int[][] points, int k) {
        

        PriorityQueue<Double[]> minHeap = new PriorityQueue<>(points.length, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] a, Double[] b){
                return  a[0] <= b[0] ? -1 : 1;
            }
        });

        for(int[] p: points){
            double distance = findDistanceFromOrigin(p);
            System.out.println(Arrays.toString(p));
            System.out.println(distance);
            System.out.println("-------");

            double x = p[0];
            double y = p[1];
            
            minHeap.add(new Double[]{ distance, x, y});
        }

        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Double[] entry = minHeap.remove();
            int x = entry[1].intValue();
            int y = entry[2].intValue();
            
            int[] coord = new int[]{x, y};
            ans.add(coord);
            
        }

        return ans.toArray(new int[ans.size()][]);
    }
 
}