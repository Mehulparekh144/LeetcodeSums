package Heap;
import java.util.*;

public class FindMedianFromDataStreamHard {

  private PriorityQueue<Integer> lmax;
  private PriorityQueue<Integer> rmin;

  public FindMedianFromDataStreamHard() {
      rmin = new PriorityQueue<>((a,b) -> a-b);
      lmax = new PriorityQueue<>((a,b) -> b-a);
    }

  public void addNum(int num) {
    if (lmax.isEmpty() || num < lmax.peek()) {
      lmax.offer(num);
    } else {
      rmin.offer(num);
    }

    // Both of the heaps should have size only by 1 element
    if (lmax.size() > rmin.size() + 1) {
      rmin.offer(lmax.poll());
    } else if (lmax.size() < rmin.size()) {
      lmax.offer(rmin.poll());
    }
  }

  public double findMedian() {
    if (lmax.size() == rmin.size()) {
      int n1 = lmax.peek();
      int n2 = rmin.peek();
      return (double) (n1 + n2) / 2;
    }

    return (double) lmax.peek();
  }
}