public class MaximumSubarrayMedium {

  public int maxSubArray(int[] nums){
    int current = 0;
    int maxi = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      current = current + nums[i];
      maxi = Integer.max(maxi , current);
      if(current < 0){
        current = 0;
      }
    }

    return maxi;

  }
  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    MaximumSubarrayMedium solver = new MaximumSubarrayMedium();
    System.out.println(solver.maxSubArray(nums));

  }
}
