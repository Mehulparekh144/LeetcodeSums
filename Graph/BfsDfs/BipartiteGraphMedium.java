package BfsDfs;
import java.util.*;

public class BipartiteGraphMedium {

  //DFS
  public boolean isBipartiteDFS(int[][] graph) {
    int[] colored = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (colored[i] == 0 && !dfs(i , colored , graph , 1)) {
        return false;
      }
    }

    return true;
  }

  private boolean dfs(int i , int[] colored , int[][] graph , int color){
    colored[i] = color;

    for(int child : graph[i]){
      if(colored[child] == 0 && !dfs(child , colored , graph , -color)){
        return false;
      }
      else if(colored[child] == color){
        return false;
      }
    }

    return true;
  }
  //BFS
  public boolean isBipartite(int[][] graph) {
    int[] colored = new int[graph.length];
    Arrays.fill(colored, -1);
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < graph.length; i++) {
      if (colored[i] == -1) {
        q.offer(i);
        colored[i] = 0;

        while (!q.isEmpty()) {
          int node = q.poll();

          for (int child : graph[node]) {
            if (colored[child] == -1) {
              q.offer(child);
              colored[child] = colored[node] == 0 ? 1 : 0;
            } else if (colored[child] == colored[node]) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }
}
