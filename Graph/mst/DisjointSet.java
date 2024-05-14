package mst;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

  List<Integer> rank;
  List<Integer> parent;
  List<Integer> size;
  public DisjointSet(int n ){
    rank = new ArrayList<>();
    parent = new ArrayList<>();
    size = new ArrayList<>();
    for(int i = 0 ; i <= n ; i++){
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  public int findUPar(int node){
    if(node == parent.get(node)) return node;
    parent.set(node , findUPar(parent.get(node)));
    return parent.get(node);
  }

  public void unionBySize(int u , int v){
    int pu = findUPar(u);
    int pv = findUPar(v);
    if(pu == pv) return;

    int sizeU = size.get(pu);
    int sizeV = size.get(pv);

    if(sizeU > sizeV){
      parent.set(pv , pu);
      size.set(pu , sizeU + sizeV);
    } else{
      parent.set(pu ,  pv);
      size.set(pv , sizeV + sizeU);
    }
  }

  public void unionByRank(int u , int v){
    int pu = findUPar(u);
    int pv = findUPar(v);

    if(pu == pv) return;
    int rankU = rank.get(pu);
    int rankV = rank.get(pv);

    if(rankU > rankV){
      parent.set(pv , pu);
    } else if(rankU < rankV){
      parent.set(pu , pv);
    } else {
      parent.set(pu , pv);
      rank.set(pv , rankV + 1);
    }
  }

  public static void main(String[] args) {
    DisjointSet ds = new DisjointSet(5);
    ds.unionByRank(0, 2);
    ds.unionByRank(4, 2);
    ds.unionByRank(3, 1);
    if (ds.findUPar(4) == ds.findUPar(0))
      System.out.println("Yes");
    else
      System.out.println("No");
    if (ds.findUPar(1) == ds.findUPar(0))
      System.out.println("Yes");
    else
      System.out.println("No");

    ds.unionBySize(0, 2);
    ds.unionBySize(4, 2);
    ds.unionBySize(3, 1);
    if (ds.findUPar(4) == ds.findUPar(0))
      System.out.println("Yes");
    else
      System.out.println("No");
    if (ds.findUPar(1) == ds.findUPar(0))
      System.out.println("Yes");
    else
      System.out.println("No");
  }
}
