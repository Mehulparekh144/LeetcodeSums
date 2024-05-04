package topoSort;
import java.util.*;

public class TopoSortMedium {

  // BFS - Kahn's Algorithm
  public static List<Integer> topologicalSortBFS(int[][] edges, int e, int v) {
    Queue<Integer> q = new LinkedList<>();
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0 ; i < v ; i++){
      adj.add(new ArrayList<>());
    }
    for(int[] edge : edges){
      adj.get(edge[0]).add(edge[1]);
    }

    int[] indegree = new int[v];
    List<Integer> res = new ArrayList<>();

    for(int[] edge : edges){
      indegree[edge[1]] += 1;
    }

    for(int i = 0 ; i < v ; i++){
      if(indegree[i] == 0){
        q.offer(i);
      }
    }

    while(!q.isEmpty()){
      int node = q.poll();
      res.add(node);

      for(int child : adj.get(node)){
        indegree[child]--;
        if(indegree[child] == 0){
          q.offer(child);
        }
      }
    }

    return res;
  }


  //DFS
  private static void dfs(int node , List<List<Integer>> adj , Stack<Integer> st , boolean[] visited){
    visited[node] = true;

    for(int child : adj.get(node)){
      if(!visited[child]){
        dfs(child , adj , st , visited);
        visited[child] = true;
      }
    }

    st.push(node);
  }

  public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
    Stack<Integer> st = new Stack<>();
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0 ; i < v ; i++){
      adj.add(new ArrayList<>());
    }
    for(int[] edge : edges){
      adj.get(edge[0]).add(edge[1]);
    }

    boolean[] visited = new boolean[v];

    for(int i = 0 ; i < v ; i++){
      if(!visited[i]){
        dfs(i , adj , st , visited);
      }
    }

    List<Integer> res = new ArrayList<>();
    while(!st.isEmpty()){
      res.add(st.pop());
    }

    return res;
  }


  public static void main(String[] args) {
    int[][] edges = {{5,0} , {5,2} , {2,3} , {3,1} , {4,1} , {4,0}};
    int e = 6;
    int v = 6;
    System.out.println(topologicalSortBFS(edges , e , v));
  }

}
