package Heap;
import java.util.*;

public class KthLargestElementInArrayMedium {
  // TWO POINTER
  private int partition(int l, int r, int[] nums) {
    int pivot = nums[l];
    int i = l + 1;
    int j = r;

    while (i <= j) {
      if (nums[i] < pivot && nums[j] > pivot) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
      }

      if (nums[i] >= pivot)
        i++;
      if (nums[j] <= pivot)
        j--;
    }

    int temp = nums[l];
    nums[l] = nums[j];
    nums[j] = temp;

    return j;

  }

  public int findKthLargest2(int[] nums, int k) {
    int l = 0;
    int r = nums.length - 1;

    int pivot = 0;

    while (true) {
      pivot = partition(l, r, nums);
      if (pivot == k - 1) {
        break;
      } else if (pivot > k - 1) {
        r = pivot - 1;
      } else {
        l = pivot + 1;
      }
    }

    return nums[pivot];
  }
  //HEAP
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : nums) {
      pq.offer(num);
    }

    int num = 0;
    while (k > 0) {
      num = pq.poll();
      k--;
    }

    return num;
  }
}
