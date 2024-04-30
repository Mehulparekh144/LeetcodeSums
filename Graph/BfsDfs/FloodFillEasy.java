package BfsDfs;

public class FloodFillEasy {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if(image[sr][sc] == color) return image;
    dfs(image , sr , sc , color , image[sr][sc]);
    return image;
  }

  private void dfs(int[][] image , int sr , int sc , int color , int src){
    if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
      return;
    }

    if(image[sr][sc] != src){
      return;
    }

    image[sr][sc] = color;
    dfs(image , sr + 1 , sc , color , src);
    dfs(image , sr , sc + 1 , color , src);
    dfs(image , sr - 1 , sc , color, src);
    dfs(image , sr , sc - 1 , color , src);
  }
}
