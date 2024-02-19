import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumTwoMedium {
  public int[] twoSum(int[] numbers, int target) {
    //Best solution
    int i = 0;
    int j = numbers.length - 1;
    int sum;
    while(i >=0 && j < numbers.length){
      sum = numbers[i] + numbers[j];
      if(sum > target){
        j--;
      } else if (sum < target) {
        i++;
      } else{
        return new int[]{i+1 , j+1};
      }
    }

    return new int[]{-1,-1};

    //Good better
//    Map<Integer, Integer> map = new HashMap<>();
//    int remain;
//    for (int i = 0; i < numbers.length; i++) {
//      remain = target - numbers[i];
//      if(map.containsKey(remain)){
//        return new int[]{map.get(remain) + 1 , i + 1};
//      }
//      else{
//        map.put(numbers[i] , i);
//      }
//    }
//    return new int[]{-1,-1};

  }

  public static void main(String[] args) {
    TwoSumTwoMedium solver = new TwoSumTwoMedium();
    int[] numbers = new int[]{2,7,11,15};
    System.out.println(Arrays.toString(solver.twoSum(numbers, 9)));
  }
}
