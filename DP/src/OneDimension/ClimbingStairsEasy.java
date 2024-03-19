package OneDimension;

public class ClimbingStairsEasy {


  public int climbStairs(int n){
    int prev2 = 1;
    int prev = 1;
    int curri;
    for (int i = 2; i <= n ; i++) {
      curri = prev2  + prev;
      prev2 = prev;
      prev = curri;
    }
    return prev;
  }

  public static void main(String[] args) {
    ClimbingStairsEasy obj = new ClimbingStairsEasy();
    System.out.println(obj.climbStairs(3));
  }
}
