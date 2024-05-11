package shortestpath;
import java.util.*;
public class BellmanFordMedium {
  static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
    // Write your code here
    int[] distances = new int[V];
    Arrays.fill(distances , (int) 1e8);
    distances[S] = 0;

    // relaxation for n-1 times
    for(int i = 0 ; i < V-1 ; i++){
      for(ArrayList<Integer> child : edges){
        int u = child.get(0);
        int v = child.get(1);
        int wt = child.get(2);

        if(distances[u] != 1e8 && distances[v] > distances[u] + wt){
          distances[v] = distances[u] + wt;
        }
      }
    }

    //relaxation to find negative cycles
    for(ArrayList<Integer> child : edges){
      int u = child.get(0);
      int v = child.get(1);
      int wt = child.get(2);

      if(distances[u] != 1e8 && distances[v] > distances[u] + wt){
        int[] temp = new int[1];
        temp[0] = -1;
        return temp;
      }
    }

    return distances;
  }
}
