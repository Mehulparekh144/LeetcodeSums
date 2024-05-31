import java.util.*;
public class Subsets {
  
  public List<List<Integer>> subsets(int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    int subsets = 1 << nums.length;
    
    for(int i = 0 ; i < subsets ; i++){
      List<Integer> temp = new ArrayList<>();
      for(int j = 0 ; j < nums.length ; j++){
        if((i & (1 << j)) != 0){
          temp.add(nums[j]);
        }
      }
      res.add(temp);
    }
    return res;
  }

  public static void main(String[] args) {
    Subsets obj = new Subsets();
    System.out.println(obj.subsets(new int[]{1,2,3,4,5}));
  }
}
