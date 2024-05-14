package mst;

import java.util.*;

public class MostStonesRemovedMedium {
  public int removeStones(int[][] stones) {
    int maxRow = 0;
    int maxCol = 0;
    for(int[] stone : stones){
      maxRow = Math.max(stone[0] , maxRow);
      maxCol = Math.max(stone[1] , maxCol);
    }

    DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
    Set<Integer> set = new HashSet<>();
    for(int[] stone : stones){
      ds.unionBySize(stone[0] , stone[1] + maxRow + 1);
      set.add(stone[0]);
      set.add(stone[1] + maxRow + 1);
    }

    int cnt = 0;
    for(int stone : set){
      if(ds.findUPar(stone) == stone){
        cnt++;
      }
    }

    return stones.length - cnt;

  }

  public static void main(String[] args) {
    MostStonesRemovedMedium obj = new MostStonesRemovedMedium();
    System.out.println(obj.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
  }
}
