import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    private void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean isInbound(int[] coord, int[][] mat) {
        int xoob = mat[0].length;
        int yoob = mat.length;

        int y = coord[0];
        int x = coord[1];

        if (x < 0 || x >= xoob || y < 0 || y >= yoob)
            return false;

        return true;
    }

    private int[][] getNeighs(int[] coord) {
        int y = coord[0];
        int x = coord[1];

        int[][] neighs = new int[][] {
                new int[] { y, x + 1 },
                new int[] { y, x - 1 },
                new int[] { y + 1, x },
                new int[] { y - 1, x },
        };

        return neighs;
    }

    public int[][] updateMatrix(int[][] mat) {
        Deque<int[][]> q = new ArrayDeque<int[][]>();
        int[][] visited = new int[mat.length][mat[0].length];
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];

            for (int j = 0; j < row.length; j++) {

                int n = mat[i][j];
                if (n == 0) {
                    res[i][j] = 0;
                    q.add(new int[][] {
                            new int[] { i, j },
                            new int[] { i, j },
                            new int[] { 0 }
                    });

                }

            }

        }


        while (q.size() != 0) {
            int[][] entry = q.pollFirst();
            int[] org = entry[0];
            int[] coord = entry[1];
            int distance = entry[2][0];
            int cy = org[0];
            int cx = org[1];

            visited[coord[0]][coord[1]] = 1;

            int[][] neighs = getNeighs(coord);
            for (int[] neigh : neighs) {
                int ny = neigh[0];
                int nx = neigh[1];

                if (isInbound(neigh, mat) && visited[ny][nx] == 0) {
                    visited[ny][nx] = 1;

                    if (mat[ny][nx] == 1) {
                        res[ny][nx] = Math.min(distance + 1, res[ny][nx]);
                        q.add(new int[][] {
                                new int[] { cy, cx },
                                new int[] { ny, nx },
                                new int[] { distance + 1 }
                        });
                    };

                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.updateMatrix(new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        });
    }
}