import java.util.*;
public class SwapNumbers {
  
  public int[] swapNumbers(int a , int b){
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    return new int[]{a,b};
  }


  public static void main(String[] args) {
    SwapNumbers obj = new SwapNumbers();
    int a = 10;
    int b = 20;
    System.out.println(Arrays.toString(obj.swapNumbers(a , b)));
  }
}
