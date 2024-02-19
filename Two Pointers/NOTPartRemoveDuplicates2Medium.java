public class NOTPartRemoveDuplicates2Medium {

  public int removeDuplicates(int[] nums){
    int i = 0;

    for(int j = 1 ; j < nums.length ; j++){
      if(nums[j] != nums[i]){
        nums[i] = nums[j+1]
        i += 1
      }
    }

    return i + 1
  }


  public static void main(String[] args) {
    int[] nums = {1,1,2,2,3,3,4,4};
    NOTPartRemoveDuplicates2Medium solver = new NOTPartRemoveDuplicates2Medium();
    return solver.removeDuplicates(nums);
  }
}
