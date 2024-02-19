public class JumpGame2Medium {
  public int jump(int[] nums){
    int l = 0;
    int r = 0;
    int res = 0;

    while(r < nums.length-1){
      int reachable = 0;
      for (int i = l; i < r+1 ; i++) {
        reachable = Math.max(reachable , i + nums[i]);
      }

      l = r + 1;
      r = reachable;
      res++;
    }

    return res;
  }
  public static void main(String[] args) {
    int[] nums = {2,3,1,1,4};
    JumpGame2Medium solver = new JumpGame2Medium();
    System.out.println(solver.jump(nums));
  }
}
