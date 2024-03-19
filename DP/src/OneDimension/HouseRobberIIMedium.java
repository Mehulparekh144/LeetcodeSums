package OneDimension;

import java.util.Arrays;

public class HouseRobberIIMedium {
  public int solve(int[] nums){
    int prev = nums[0];
    int prev2 = 0;
    for(int i = 1 ; i < nums.length ; i++){
      int pick = nums[i];
      if(i > 1){
        pick += prev2;
      }
      int np = prev;
      int curr = Math.max(pick , np);
      prev2 = prev;
      prev = curr;
    }
    return prev;
  }

  public int rob(int[] nums){
    if(nums.length == 1) return nums[0];
    int ans1 = solve(Arrays.copyOfRange(nums , 0 , nums.length - 1));
    int ans2 = solve(Arrays.copyOfRange(nums , 1 , nums.length));
    return Math.max(ans1 , ans2);
  }

  public static void main(String[] args) {
    HouseRobberIIMedium obj = new HouseRobberIIMedium();
    System.out.println(obj.rob(new int[]{200,3,140,20,10}));
  }

}
