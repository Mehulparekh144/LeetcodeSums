public class MinimumRotatedMedium {

  public int findMinimum(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int result = Integer.MAX_VALUE;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (nums[l] <= nums[mid]) {
        result = Math.min(result, nums[l]);
        l = mid + 1;
      } else {
        result = Math.min(result, nums[mid]);
        r = mid - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 }; // Example rotated sorted array
    MinimumRotatedMedium solver = new MinimumRotatedMedium();
    int min = solver.findMinimum(nums);
    System.out.println("Minimum element: " + min);
  }

}
