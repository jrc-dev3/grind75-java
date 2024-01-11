import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

  private boolean isInbound(int[] coord, int[][] matrix) {
    int xMin = 0;
    int yMin = 0;
    int xOob = matrix[0].length;
    int yOob = matrix.length;

    int x = coord[0];
    int y = coord[1];

    if (x < xMin || x >= xOob || y < yMin || y >= yOob)
      return false;

    return true;

  }

  private int[][] getNeighs(int[] coord, int[][] matrix) {

    int x = coord[0];
    int y = coord[1];
    int[][] neighs = new int[4][2];

    int[][] moves = new int[][] {
        new int[] { 0, 1 },
        new int[] { 0, -1 },
        new int[] { 1, 0 },
        new int[] { -1, 0 }
    };

    for (int i = 0; i < moves.length; i++) {
      int dx = moves[i][0];
      int dy = moves[i][1];
      neighs[i] = new int[] { x + dx, y + dy };
    }

    return neighs;

  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {

    int currColor = image[sr][sc];
    int newColor = color;

    Deque<int[]> q = new ArrayDeque<int[]>() {
      {
        add(new int[] { sc, sr });
      }
    };

    char[][] visited = new char[image.length][image[0].length];
    visited[sr][sc] = 'v';

    while (q.size() != 0) {

      int[] currCoord = q.removeFirst();

      int[][] neighs = getNeighs(currCoord, image);
      for (int[] neigh : neighs) {
        int nx = neigh[0];
        int ny = neigh[1];

        if (isInbound(neigh, image) && visited[ny][nx] != 'v' && image[ny][nx] == currColor ) {
          visited[ny][nx] = 'v';
          q.add(neigh);
          image[ny][nx] = newColor;

        }

      }
    }
    image[sr][sc] = newColor;
    return image;

  }

  public static void main(String[] args) {
    int[][] image = new int[][]{
      new int[]{0,0,1},
      new int[]{1,0,0}
    };

    for(int[] r: image){
      System.out.println(Arrays.toString(r));
    }
    Solution sol = new Solution();
    int[][] ans = sol.floodFill(image, 1, 0, 2);
    
    for(int[] r: ans){
      System.out.println(Arrays.toString(r));
    }
  }

}