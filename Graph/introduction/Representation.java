package introduction;

import java.util.ArrayList;

public class Representation {

  public void makeAdjList(int n , int m ){
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0 ; i <= n ; i++){
      adj.add(new ArrayList<>());
    }

    // (1,2) (1,3) (3,4) (2,4) (2,5) (4,5)
    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(1).add(3);
    adj.get(3).add(1);

    adj.get(3).add(4);
    adj.get(4).add(3);

    adj.get(2).add(5);
    adj.get(5).add(2);
  }
  // Adjacency matrix
  public void makeAdjMatrix(int n , int m){
    int[][] adj = new int[n+1][n+1];

    // (1,2) (1,3) (3,4) (2,4) (2,5) (4,5)
    // adj[u][v] = 1;
    // adj[v][u] = 1;
    adj[1][2] = 1;
    adj[2][1] = 1;

    adj[1][3] = 1;
    adj[3][1] = 1;

    adj[3][4] = 1;
    adj[4][3] = 1;

    adj[2][4] = 1;
    adj[4][2] = 1;

    adj[2][5] = 1;
    adj[5][2] = 1;

    adj[4][5] = 1;
    adj[5][4] = 1;
  }
}
