package BfsDfs;
import java.util.*;

public class CycleInDirectedGraph {
  private static Boolean dfs(int start , List<List<Integer>> adj , int[] visited , int[] pathVisited){
    visited[start] = 1;
    pathVisited[start] = 1;

    for(int child : adj.get(start)){
      if(visited[child] == 0){
        if(dfs( child , adj , visited , pathVisited)){
          return true;
        }
      } else if(pathVisited[child] == 1){
        return true;
      }
    }

    pathVisited[start] = 0;
    return false;
  }
  public static Boolean isCyclic(int[][] edges, int v, int e)
  {
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0 ; i < v ; i++){
      adj.add(new ArrayList<>());
    }

    for(int[] edge : edges){
      adj.get(edge[0]).add(edge[1]);
    }


    int[] visited = new int[v];
    int[] pathVisited = new int[v];
    for(int i = 0 ; i < v ; i++){
      if(visited[i] == 0){
        if(dfs(i , adj , visited , pathVisited)){
          return true;
        }
      }
    }

    return false;
  }

}
