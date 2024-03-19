package OneDimension;

import java.util.Arrays;

public class HouseRobberMedium {

  public int rob(int[] nums){
    int[] dp = new int[nums.length];
    Arrays.fill(dp , -1);

    int prev = nums[0];
    int prev2 = 0;
    for (int i = 1 ; i < nums.length ; i++) {
      int pick  = nums[i] + prev2;
      int notPick = prev;
      int curr = Math.max(pick , notPick);
      prev2 = prev;
      prev = curr;
    }
    return prev;
  }

  public static void main(String[] args) {
    HouseRobberMedium obj = new HouseRobberMedium();
    System.out.println(obj.rob(new int[]{2,7,9,3,1}));
  }
}
