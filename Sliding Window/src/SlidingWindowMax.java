import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {

  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    int[] res = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
      if (!dq.isEmpty() && dq.peekFirst() == i - k) {
        dq.pollFirst();
      }

      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }

      dq.offerLast(i);

      if (i >= k - 1) {
        res[i - k + 1] = nums[dq.peekFirst()];
      }
    }

    return res;

  // BRUTE
  // int[] res = new int[nums.length];
  // int i = 0;
  // while (k <= nums.length) {
  // res[i] = Arrays.stream(Arrays.copyOfRange(nums, i, k)).max().getAsInt();
  // k++;
  // i++;
  // }

  // return res;
  }

  public static void main(String[] args) {
    SlidingWindowMax solver = new SlidingWindowMax();
    int[] res = solver.maxSlidingWindow(new int[] { 7, 2, 4 }, 2);
    System.out.println(Arrays.toString(res));
  }
}
