package mst;
import java.util.*;

public class PrimsAlgoMedium {
  static class Pair{
    int wt;
    int node;
    int parent; // Only if you want to print the resulting mst

    public Pair(int wt, int node , int parent){
      this.wt = wt;
      this.node = node;
    }

  }
  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparing(x -> x.wt));
    boolean[] visited = new boolean[V];
    pq.offer(new Pair(0 , 0 , -1)); // you can add any node not necessarily 0.
    int sum = 0;
    List<int[]> mst = new ArrayList<>(); // Only if you want to print the resulting mst.

    while(!pq.isEmpty()){
      int node = pq.peek().node;
      int wt = pq.peek().wt;
      int parent = pq.peek().parent;
      pq.poll();

      if(visited[node]) continue;

      visited[node] = true;
      if(parent != -1){
        mst.add(new int[]{node , parent});
      }
      sum += wt;

      for(int[] it : adj.get(node)){
        int edgeWt = it[1];
        int child = it[0];

        if(!visited[child]){
          pq.offer(new Pair(edgeWt , child , node));
        }
      }
    }

    for(int[] edge : mst){
      System.out.println(Arrays.toString(edge));
    }

    return sum;
  }

  public static void main(String[] args) {
    List<List<int[]>> adj = new ArrayList<>();
    adj.add(List.of(new int[]{1, 5}));
    adj.add(List.of(new int[]{2, 3}));
    adj.add(List.of(new int[]{2, 1}));
    System.out.println(spanningTree(3 , 3 , adj));
  }

}
