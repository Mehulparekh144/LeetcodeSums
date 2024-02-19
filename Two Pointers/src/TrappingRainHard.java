import java.util.Arrays;

public class TrappingRainHard
{

  public int trap(int[] height){
//    OPTIMAL
    int res = 0;
    int leftMax = 0;
    int rightMax = 0;
    int l = 0; int r = height.length - 1;

    while(l < r){
      if(height[l] <= height[r]){
        if(height[l] >= leftMax){
          leftMax = height[l];
        }
        else{
          res += leftMax - height[l];
        }
        l++;
      }
      else{
        if(height[r] >= rightMax){
          rightMax = height[r];
        }
        else{
          res += rightMax - height[r];
        }
        r--;
      }
    }
    return res;

   //BETTER
//    int res = 0;
//    int[] prefixSum = new int[height.length];
//    int[] suffixSum = new int[height.length];
//    prefixSum[0] = height[0];
//    suffixSum[height.length - 1] = height[height.length-1];
//
//    for (int i = 1; i < height.length ; i++) {
//      prefixSum[i] = Math.max(prefixSum[i-1] , height[i]);
//    }
//
//    for (int i = height.length - 2; i > -1; i--) {
//      suffixSum[i] = Math.max(suffixSum[i+1] , height[i]);
//    }
//
////    System.out.println(Arrays.toString(prefixSum));
////    System.out.println(Arrays.toString(suffixSum));
//
//    for (int i = 0; i < height.length; i++) {
//      res += Math.min(prefixSum[i] , suffixSum[i]) - height[i] ;
//    }
//
//    return res;

    //BRUTE
//    int res = 0;
//    int j ;
//
//    for (int i = 0; i < height.length; i++) {
//      j = i;
//      int leftMax = 0, rightMax = 0;
//
//      while(j >= 0){
//        leftMax = Math.max(leftMax , height[j]);
//        j --;
//      }
//
//      j = i;
//      while(j < height.length){
//        rightMax = Math.max(rightMax , height[j]);
//        j ++;
//      }
//
//      res += Math.min(leftMax , rightMax) - height[i];
//    }
//
//    return res;
  }
  public static void main(String[] args) {
    TrappingRainHard solver = new TrappingRainHard();
    System.out.println(solver.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }
}
