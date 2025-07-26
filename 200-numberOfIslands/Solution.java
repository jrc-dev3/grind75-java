import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    private int[][] getNeighs(int[] coord) {
        int cy = coord[0];
        int cx = coord[1];

        return new int[][] {
                new int[] { cy + 1, cx },
                new int[] { cy - 1, cx },
                new int[] { cy, cx + 1 },
                new int[] { cy, cx - 1 },
        };

    }

    private boolean isInbound(int[] coord, char[][] grid) {

        int yoob = grid.length;
        int xoob = grid[0].length;

        return coord[0] >= 0 && coord[0] < yoob && coord[1] >= 0 && coord[1] < xoob;

    }

    public int numIslands(char[][] grid) {

        int ans = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for (int y = 0; y < grid.length; y++) {

            for (int x = 0; x < grid[0].length; x++) {

                if (grid[y][x] == '1' && visited[y][x] == 0) {
                    ans++;
                    Deque<int[]> q = new ArrayDeque<>();

                    q.add(new int[] { y, x });
                    visited[y][x] = 1;

                    while (!q.isEmpty()) {

                        int[] coord = q.pollFirst();
                        int[][] neighs = getNeighs(coord);

                        for (int[] neigh : neighs) {
                            if (isInbound(neigh, grid)) {

                                if (visited[neigh[0]][neigh[1]] == 0 && grid[neigh[0]][neigh[1]] == '1'){
                                    visited[neigh[0]][neigh[1]] = 1;
                                    q.add(neigh);
                                }

                            }
                        }
                    }
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.numIslands(new char[][] {
                new char[] { '1', '1', '1', '1', '0' },
                new char[] { '1', '1', '0', '1', '0' },
                new char[] { '0', '0', '0', '0', '0' }
        });
        System.out.println(ans);
    }
}