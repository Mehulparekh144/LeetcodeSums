package shortestpath;
import java.util.*;
public class NetworkDelayTime {
  class Pair{
    int node;
    int time;

    public Pair(int node , int time){
      this.node = node;
      this.time = time;
    }
  }
  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<Pair>> adj = new ArrayList<>();
    for(int i = 0 ; i <= n ; i++){
      adj.add(new ArrayList<>());
    }
    for(int[] time : times){
      adj.get(time[0]).add(new Pair(time[1] , time[2]));
    }
    int[] t = new int[n + 1];
    Arrays.fill(t , (int) 1e9);
    t[k] = 0;
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(k , 0));

    while(!q.isEmpty()){
      Pair current = q.poll();

      for(Pair child : adj.get(current.node)){
        if(t[child.node] > child.time + current.time){
          t[child.node] = child.time + current.time;
          q.offer(new Pair(child.node , t[child.node]));
        }
      }
    }

    int maxi = Integer.MIN_VALUE;
    for(int i = 1 ; i <= n ; i++){
      if(t[i] == (1e9)) return -1;
      maxi = Math.max(maxi , t[i]);
    }

    return maxi;

  }
}
