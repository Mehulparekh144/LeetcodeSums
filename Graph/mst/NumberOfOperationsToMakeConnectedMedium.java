package mst;

public class NumberOfOperationsToMakeConnectedMedium {

    public int makeConnected(int n, int[][] connections) {
      DisjointSet d = new DisjointSet(n);
      int extraCables = 0;
      for(int[] connection : connections){
        if(d.findUPar(connection[0]) == d.findUPar(connection[1])){
          extraCables++;
        } else{
          d.unionBySize(connection[0] , connection[1]);
        }
      }

      int notConnected = 0;
      for(int i = 0 ; i < n ; i++){
        if(d.parent.get(i) == i) notConnected++;
      }

      int answer = notConnected - 1;
      if(extraCables >= answer) return answer ;
      return -1;


    }
}
