package Heap;
import java.util.*;

public class KthLargestElementEasy {
  private PriorityQueue<Integer> pq;
  private int k;

  public KthLargestElementEasy(int k, int[] nums) {
    this.k = k;
    pq = new PriorityQueue<>(k);
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {
    pq.offer(val);
    if (pq.size() > k) {
      pq.poll();
    }

    return pq.peek();
  }
  public static void main(String[] args) {
    KthLargestElementEasy obj = new KthLargestElementEasy(3, new int[]{4,5,8,2});
    System.out.println(obj.add(3));
  }
}
