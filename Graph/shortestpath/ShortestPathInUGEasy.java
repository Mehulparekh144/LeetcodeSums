package shortestpath;
import java.util.*;
public class ShortestPathInUGEasy {

    static class Pair{
      int node;
      int distance;
      public Pair(int node , int distance){
        this.node = node;
        this.distance = distance;
      }
    }
    public static int[] shortestPath(int n, int [][]edges, int src) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0 ; i < n ; i++){
        adj.add(new ArrayList<>());
      }
      for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }
      int[] distances = new int[n];
      boolean[] visited = new boolean[n];
      Arrays.fill(distances , -1);

      Queue<Pair> q = new LinkedList<>();
      q.offer(new Pair(src , 0 ));
      distances[src] = 0;
      visited[src] = true;

      while(!q.isEmpty()){
        Pair p = q.poll();
        int node = p.node;
        int distance = p.distance;

        for(int child : adj.get(node)){
          if(!visited[child]){
            visited[child] = true;
            if(distances[child] == -1) distances[child] = distance + 1;
            q.offer(new Pair(child , distance + 1));
          }
        }
      }

      return distances;
    }


  public static void main(String[] args) {
    int n = 5;
    int[][] edges = new int[][]{{0, 1}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
    int src = 1;
    int[] result = shortestPath(n, edges, src);
    for(int i : result){
      System.out.print(i + " ");
    }
  }

}
