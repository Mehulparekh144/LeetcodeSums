package shortestpath;
import java.util.*;

public class ShortestPathInDAGEasy {
  static class Pair{
    int node;
    int distance;
    public Pair(int node , int distance){
      this.node = node;
      this.distance = distance;
    }
  }

  //DFS
  private static void topoSort(int node , List<List<Pair>> adj , boolean[] visited , Stack<Integer> st){
    visited[node] = true;
    for(Pair p : adj.get(node)){
      if(!visited[p.node]){
        topoSort(p.node, adj, visited, st);
      }
    }

    st.push(node);

  }
  public static int[] shortestPathInDAGDDFS(int n, int m, int [][]edges) {
    // Write your code here
    List<List<Pair>> adj = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
      adj.add(new ArrayList<>());
    }

    for(int[] edge : edges){
      adj.get(edge[0]).add(new Pair(edge[1] , edge[2]));
    }

    int[] distances = new int[n];
    Arrays.fill(distances, (int)1e9);
    boolean[] visited = new boolean[n];
    Stack<Integer> st = new Stack<>();
    for(int i = 0 ; i < n ; i++){
      if(!visited[i]){
        topoSort(i, adj, visited, st);
      }
    }

    distances[0] = 0;
    while(!st.isEmpty()){
      int node = st.pop();

      for(Pair p : adj.get(node)){
        int child = p.node;
        int dist = p.distance;

        if(distances[node] + dist < distances[child]){
          distances[child] = distances[node] + dist;
        }
      }
    }

    for(int i = 0 ; i < n ; i++){
      if(distances[i] == 1e9){
        distances[i] = -1;
      }
    }

    return distances;

  }

  //BFS
  public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
    // Write your code here
    List<List<Pair>> adj = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
      adj.add(new ArrayList<>());
    }

    for(int[] edge : edges){
      adj.get(edge[0]).add(new Pair(edge[1] , edge[2]));
    }

    Queue<Pair> q = new LinkedList<>();
    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);
    q.offer(new Pair(0, 0));
    distances[0] = 0;

    while(!q.isEmpty()){
      Pair p = q.poll();
      int node = p.node;
      int distance = p.distance;

      for(Pair child : adj.get(node)){
        distances[child.node] = Math.min(distances[child.node] , distance + child.distance);
        q.offer(new Pair(child.node , distance + child.distance));
      }
    }

    for(int i = 0 ; i < n ; i++){
      if(distances[i] == Integer.MAX_VALUE){
        distances[i] = -1;
      }
    }

    return distances;

  }
}
