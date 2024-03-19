package OneDimension;

public class MinCostClimbingEasy {

  int[] dp;
  public int minCostClimbingStairs(int[] cost){
    int prev = cost[cost.length - 2];
    int prev2 = cost[cost.length - 1];
    for (int j = cost.length - 3; j >= 0; j--) {
      int curr = cost[j] +  Math.min(prev , prev2);
      prev2 = prev;
      prev = curr;
    }
    return Math.min(prev , prev2);
  }

  public static void main(String[] args) {
    MinCostClimbingEasy obj = new MinCostClimbingEasy();
    System.out.println(obj.minCostClimbingStairs(new int[]{10,15,20}));
  }
}
