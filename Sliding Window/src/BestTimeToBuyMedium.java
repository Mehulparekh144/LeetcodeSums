public class BestTimeToBuyMedium {

  public int maxProfit(int[] prices){
    int min = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if( prices[i] < min) {
        min = prices[i];
      }
      maxProfit = Math.max(maxProfit , prices[i] - min);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    BestTimeToBuyMedium solver = new BestTimeToBuyMedium();
    System.out.println(solver.maxProfit(new int[] {7,1,5,3,6,4}));
  }
}
