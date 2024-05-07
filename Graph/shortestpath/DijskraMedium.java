package shortestpath;
import java.util.*;

public class DijskraMedium {
  static class Pair{
    int distance;
    int node;

    public Pair(int distance , int node){
      this.distance = distance;
      this.node = node;
    }

    @Override
    public String toString() {
      return distance + " " + node ;
    }
  }

  public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
    // Write your code here.
    TreeSet<Pair> set =
            new TreeSet<Pair>(Comparator.comparingInt((Pair x) -> x.distance).
                    thenComparing(Comparator.comparingInt(x -> x.node)));
    int[] distances = new int[vertices];
    Arrays.fill(distances , (int) 1e9);
    List<List<Pair>> adj = new ArrayList<>();

    for(int i = 0 ; i < vertices ; i++) adj.add(new ArrayList<>());

    for(int[] it : edge){
      adj.get(it[0]).add(new Pair(it[2] , it[1]));
      adj.get(it[1]).add(new Pair(it[2] , it[0]));
    }

    System.out.println(adj);

    distances[source] = 0;
    set.add(new Pair(0 , source));

    while(!set.isEmpty()){
      Pair p = set.pollFirst();
      int node = p.node;
      int distance = p.distance;

      for(Pair child : adj.get(node)){
        if(distance + child.distance < distances[child.node]){
          // If distances is visited. Then remove it from the set
          if(distances[child.node] != 1e9){
            set.remove(new Pair(distances[child.node] , child.node));
          }
          distances[child.node] = distance + child.distance;
          set.add(new Pair(distances[child.node] , child.node));
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    for(int element : distances){
      list.add(element);
    }
    return list;
//

  }

  //Using Priority Queue
  public static List<Integer> dijkstraPQ(int[][] edge,int vertices, int edges,int source){
    // Write your code here.
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
    int[] distances = new int[vertices];
    Arrays.fill(distances , (int) 1e9);
    List<List<Pair>> adj = new ArrayList<>();

    for(int i = 0 ; i < vertices ; i++) adj.add(new ArrayList<>());

    for(int[] it : edge){
      adj.get(it[0]).add(new Pair(it[2] , it[1]));
      adj.get(it[1]).add(new Pair(it[2] , it[0]));
    }

    distances[source] = 0;
    pq.add(new Pair(0 , source));

    while(!pq.isEmpty()){
      Pair p = pq.remove();
      int node = p.node;
      int distance = p.distance;

      for(Pair child : adj.get(node)){
        if(distance + child.distance < distances[child.node]){
          distances[child.node] = distance + child.distance;
          pq.add(new Pair(distances[child.node] , child.node));
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    for(int element : distances){
      list.add(element);
    }
    return list;
//

  }

  public static void main(String[] args) {
    int[][] edges = {
            {2, 3, 5},
            {0, 3, 2},
            {1, 0, 8},
            {1, 4, 1},
            {0, 4, 8},
            {3, 4, 2},
            {1, 2, 10},
            {0, 2, 9},
            {2, 4, 3},
            {1, 3, 10}
    };

    System.out.println(dijkstra(edges , 5 , 10 , 3));
  }
}
