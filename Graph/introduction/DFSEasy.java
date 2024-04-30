package introduction;
import java.util.*;
public class DFSEasy {
  private void dfs(ArrayList<ArrayList<Integer>> adj , int node ,
                   boolean[] visited , List<Integer> result){
    visited[node] = true;
    result.add(node);

    for(int neighbor : adj.get(node)){
      if(!visited[neighbor]){
        dfs(adj , neighbor , visited , result);
      }
    }

  }
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here
    ArrayList<Integer> result = new ArrayList<>();
    dfs(adj , 0 , new boolean[V] , result);
    return result;

  }
}
