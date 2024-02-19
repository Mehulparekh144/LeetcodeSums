public class DuplicateMedium {
  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;

// This detects the cycle but not the value
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }
    while (slow != fast);
// This detects the value as slow2 starts from entry
    int slow2 = 0;
    do {
      slow = nums[slow];
      slow2 = nums[slow2];
    }while(slow2 != slow);

    return slow;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,4,2,2};
    DuplicateMedium solver = new DuplicateMedium();
    System.out.println(solver.findDuplicate(nums));

  }
}
