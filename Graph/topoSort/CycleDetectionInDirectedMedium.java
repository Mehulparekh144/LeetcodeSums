package topoSort;
import java.util.*;

public class CycleDetectionInDirectedMedium {

  //KAHN's Algo
  public static boolean detectCycleInDirectedGraphBFS(int n,
                                                    ArrayList < ArrayList < Integer >> edges) {
    Queue<Integer> q = new LinkedList<>();
    List<List<Integer>> adj = new ArrayList();
    for(int i = 0 ; i <= n ;i++){
      adj.add(new ArrayList<>());
    }

    int[] indegree = new int[n+1];
    for(List<Integer> edge : edges){
      indegree[edge.get(1)] ++;
    }

    for(List<Integer> edge : edges){
      adj.get(edge.get(0)).add(edge.get(1));
    }

    for(int i = 1 ; i <= n ; i++){
      if(indegree[i] == 0){
        q.offer(i);
      }
    }

    int count = 0 ;

    while(!q.isEmpty()){
      int node = q.poll();
      count++;

      for(int child : adj.get(node)){
        indegree[child]--;
        if(indegree[child] == 0){
          q.offer(child);
        }
      }
    }

    return count != n;

  }
  private static boolean dfs(int node ,List<List<Integer >> adj , Stack<Integer> st , boolean[] visited){
    visited[node] = true;
    st.push(node);

    for(int child : adj.get(node)){
      if(!visited[child]){
        if(dfs(child , adj , st , visited)) {
          return true;
        }
      }
      else if(st.contains(child)) return true;
    }
    st.pop();
    return false;
  }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    Stack<Integer> st = new Stack<>();
    List<List<Integer>> adj = new ArrayList();
    for(int i = 0 ; i <= n ;i++){
      adj.add(new ArrayList<>());
    }

    for(List<Integer> edge : edges){
      adj.get(edge.get(0)).add(edge.get(1));
    }
    boolean[] visited = new boolean[n+1];

    for(int i = 1 ; i <= n ; i++){
      if(!visited[i]){
        if(dfs(i , adj , st , visited)){
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    ArrayList<Integer> edge1 = new ArrayList<>();
    edge1.add(1);
    edge1.add(2);
    ArrayList<Integer> edge2 = new ArrayList<>();
    edge2.add(4);
    edge2.add(1);
    ArrayList<Integer> edge3 = new ArrayList<>();
    edge3.add(2);
    edge3.add(4);
    ArrayList<Integer> edge4 = new ArrayList<>();
    edge4.add(3);
    edge4.add(4);
    ArrayList<Integer> edge5 = new ArrayList<>();
    edge5.add(5);
    edge5.add(2);
    ArrayList<Integer> edge6 = new ArrayList<>();
    edge6.add(1);
    edge6.add(3);
    edges.add(edge1);
    edges.add(edge2);
    edges.add(edge3);
    edges.add(edge4);
    edges.add(edge5);
    edges.add(edge6);
    System.out.println(detectCycleInDirectedGraph(5, edges));
  }
}
