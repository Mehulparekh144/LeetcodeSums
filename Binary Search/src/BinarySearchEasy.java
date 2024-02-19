public class BinarySearchEasy {

  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = (l + r) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      else if (nums[mid] > target) {
        r = mid - 1;
      }

      else {
        l = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    BinarySearchEasy solver = new BinarySearchEasy();
    System.out.println(solver.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
  }
}
