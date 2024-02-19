import java.util.ArrayList;
import java.util.List;

public class MedianHard {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    // OPTIMAL - 2 Pointer
    // int totalLength = nums1.length + nums2.length;
    // int medianIndex = totalLength / 2;

    // int ptr1 = 0;
    // int ptr2 = 0;
    // int prev = 0;
    // int curr = 0;

    // for (int i = 0; i <= medianIndex; i++) {
    // prev = curr;
    // if (ptr1 < nums1.length && (ptr2 >= nums2.length || nums1[ptr1] <
    // nums2[ptr2])) {
    // curr = nums1[ptr1++];
    // } else {
    // curr = nums2[ptr2++];
    // }
    // }

    // if (totalLength % 2 != 0) {
    // return (double) curr;
    // } else {
    // return (double) (prev + curr) / 2.0;
    // }

    // BRUTE
    // List<Integer> nums = new ArrayList<>();
    // for (int num : nums1) {
    // nums.add(num);
    // }
    // for (int num : nums2) {
    // nums.add(num);
    // }
    // nums.sort(null);
    // System.out.println(nums);
    // int l = 0;
    // int r = nums.size() - 1;
    // if (nums.size() % 2 == 0) {
    // int mid = l + (r - l) / 2;
    // return (double) (nums.get(mid) + nums.get(mid + 1)) / 2;
    // }
    // int mid = l + (r - l) / 2;
    // return (double) nums.get(mid);

  }

  public static void main(String[] args) {
    MedianHard solver = new MedianHard();
    System.out.println(solver.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3 }));
  }
}
