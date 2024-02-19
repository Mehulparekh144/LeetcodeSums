import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSumMedium {

  public List<List<Integer>> threeSum(int[] nums) {
    if(nums == null || nums.length < 3) {
      return new ArrayList<>();
    }

    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          set.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return new ArrayList<>(set);



//    List<List<Integer>> res = new ArrayList<>();
//
//    Arrays.sort(nums);
//
//    for (int i = 0; i < nums.length; i++) {
//      Set<Integer> hashSet = new HashSet<>();
//      for (int j = i + 1; j < nums.length; j++) {
//        int sum = -(nums[i] + nums[j]);
//
//        if (hashSet.contains(sum)) {
//          List<Integer> temp = Arrays.asList(sum, nums[i], nums[j]);
//          if (!res.contains(temp)) {
//            res.add(temp);
//          }
//        } else {
//          hashSet.add(nums[j]);
//        }
//      }

//    return res;
  }

  public static void main(String[] args) {
    ThreeSumMedium solver = new ThreeSumMedium();
    int[] nums = new int[]{-1,0,1,2,-1,-4};
    System.out.println(solver.threeSum(nums));
  }
}
