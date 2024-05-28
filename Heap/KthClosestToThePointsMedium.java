package Heap;
import java.util.*;

public class KthClosestToThePointsMedium {
  class Pair {
    int[] point;
    double distance;

    public Pair(int[] point, double distance) {
      this.point = point;
      this.distance = distance;
    }

    @Override
    public String toString(){
      return Arrays.toString(point) + "," + distance;
    }
  }

  // Using Heap
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

    for (int[] point : points) {
      int x = point[0];
      int y = point[1];
      double distance = Math.sqrt(x * x + y * y);
      if (pq.size() == k) {
        pq.poll();
      }
      pq.offer(new Pair(point, distance));
    }

    int[][] ans = new int[pq.size()][2];
    int i = 0;
    while (!pq.isEmpty()) {
      ans[i] = pq.poll().point;
      i++;
    }

    return ans;

    }

    public static void main(String[] args) {
      KthClosestToThePointsMedium obj = new KthClosestToThePointsMedium();
      System.out.println(Arrays.toString(obj.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2)));
    }
}