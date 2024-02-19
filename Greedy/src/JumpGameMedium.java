public class JumpGameMedium {

  public boolean canJump(int[] nums){
    int reachable = 0;
    for (int i = 0; i < nums.length ; i++) {
      System.out.println("Iteration : " + i);
      System.out.println("Reachable : " + reachable);
      System.out.println("\n");
      if(i > reachable) return false;
      reachable = Math.max(reachable , nums[i] + i);
    }

    return true;
  }
  public static void main(String[] args) {
    int[] nums = {3,2,1,0,4};
    JumpGameMedium solver = new JumpGameMedium();
    System.out.println(solver.canJump(nums));
  }
}
