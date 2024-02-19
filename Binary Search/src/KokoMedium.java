import java.util.Arrays;

public class KokoMedium {

  public int minEatingSpeed(int[] piles, int h) {

    int l = 1 ; 
    int r = Arrays.stream(piles).max().getAsInt();
  
    while(l <= r){    
      int k = l + (r-l)/2;
      int hrs = 0;
  
      for(int pile : piles){  
        hrs += Math.ceil(1.0 * pile/k);
      }
  
      if(hrs <= h){
        r = k - 1;
      } else {
        l = k + 1;
      }
    }
    return l;

    // BRUTE
    // int max = Arrays.stream(piles).max().getAsInt();
    // int result = Integer.MAX_VALUE;

    // for (int k = 1; k <= max; k++) {
    // int hrs = 0;
    // for (int pile : piles) {
    // hrs += Math.ceil(1.0 * pile / k);
    // }
    // if (hrs <= h) {
    // result = Math.min(result, k);
    // }
    // }
    // return result;
  }

  public static void main(String[] args) {
    KokoMedium solver = new KokoMedium();     
    System.out.println(solver.minEatingSpeed(new int[] {3,6,7,11}, 8));
  }
}
