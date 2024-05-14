package mst;

import java.util.*;

public class KruskalsAlgoMedium {

  static class Pair {
    int wt;
    int u;
    int v;

    public Pair(int wt, int u, int v) {
      this.wt = wt;
      this.u = u;
      this.v = v;
    }
  }

  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    List<Pair> edges = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        int u = i;
        int v = adj.get(i).get(j)[0];
        int wt = adj.get(i).get(j)[1];
        Pair pair = new Pair(wt , u , v);
        edges.add(pair);
      }
    }

    DisjointSet d = new DisjointSet(V);

    int sum = 0;
    edges.sort(Comparator.comparing(x -> x.wt));
    for(Pair edge : edges){
      int u = edge.u;
      int v = edge.v;
      int wt = edge.wt;

      if(d.findUPar(u) != d.findUPar(v)){
        sum += wt;
        d.unionByRank(u , v);
      }

    }

    return sum;
  }
}

