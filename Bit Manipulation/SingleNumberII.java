import java.util.Arrays;

public class SingleNumberII {

  

  // OPTIMAL TC - O(nlogn + n/3)
  public int singleNumber2(int[] nums) {
    // O(nlogn);
    Arrays.sort(nums);
    int i = 1;
    // O(n/3);
    while (i < nums.length) {
      if (nums[i] != nums[i - 1]) {
        return nums[i - 1];
      }

      i += 3;
    }

    return nums[nums.length - 1];
    // TC - O(nlogn + n/3)
  }

  // BETTER TC - O(32n);
  public int singleNumber(int[] nums) {
    int ans = 0;

    for (int bit = 0; bit < 32; bit++) {
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if ((nums[i] & (1 << bit)) != 0) {
          count++;
        }
      }

      if (count % 3 == 1) {
        ans = ans | (1 << bit);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    SingleNumberII obj = new SingleNumberII();
    System.out.println(obj.singleNumber(new int[] { 5, 5, 5, 2, 4, 4, 4 }));
  }
}
