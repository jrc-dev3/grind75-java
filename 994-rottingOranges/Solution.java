import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {

    private boolean isInbound(int[] coord, int[][] matrix) {
        int yMin = 0;
        int xMin = 0;
        int yOob = matrix.length;
        int xOob = matrix[0].length;

        int y = coord[0];
        int x = coord[1];

        if (x < xMin || x >= xOob || y < yMin || y >= yOob)
            return false;

        return true;

    }

    private int[][] getNeighs(int[] coord, int[][] matrix) {
    int y = coord[0];
    int x = coord[1];

    int[][] moves = new int[][] {
        { 1, 0 },   // down
        { -1, 0 },  // up
        { 0, 1 },   // right
        { 0, -1 }   // left
    };

    List<int[]> neighbors = new ArrayList<>();

    for (int[] move : moves) {
        int ny = y + move[0];
        int nx = x + move[1];

        int[] newCoord = new int[] { ny, nx };
        if (isInbound(newCoord, matrix)) {
            neighbors.add(newCoord);
        }
    }

    return neighbors.toArray(new int[neighbors.size()][]);
}


    public int orangesRotting(int[][] grid) {

        Deque<int[]> q = new ArrayDeque<int[]>();
        char[][] visited = new char[grid.length][grid[0].length]; // y,x
        int turns = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {

                int val = grid[y][x];

                if (val == 0) {
                    visited[y][x] = 'v';
                    continue;
                }

                if (val == 2) {
                    visited[y][x] = 'v';
                    q.add(new int[] { y, x, 0 });
                }

            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.pop();
            int y = curr[0];
            int x = curr[1];
            int turn = curr[2];
            turns = Math.max(turn, turns);

            int[][] neighs = getNeighs(new int[] { y, x }, grid);
            for (int[] n : neighs) {
                int ny = n[0];
                int nx = n[1];


                if (visited[ny][nx] == '\0' && grid[ny][nx] == 1) {

                    visited[ny][nx] = 'v';
                    grid[ny][nx] = 2;
                    q.add(new int[] { ny, nx, turn + 1 });

                }

            }

        }

        for(int[] row: grid){
            for(int val: row){

                if(val == 1){
                    return -1;
                }
            }
        }

        return turns;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.orangesRotting(new int[][] {
                new int[] { 1, 0, 2, 2, 2 }
        });
        System.out.println(ans);
    }

}