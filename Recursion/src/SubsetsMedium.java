import java.util.ArrayList;
import java.util.List;

public class SubsetsMedium {
  List<List<Integer>> result;

  public void solve(int[] nums, int i, List<Integer> temp) {
    if (i >= nums.length) {
      result.add(new ArrayList<>(temp));
      return;
    }
    // chose
    temp.add(nums[i]);
    solve(nums, i + 1, temp);

    temp.remove(temp.size() - 1);
    // not chose
    solve(nums, i + 1, temp);
  }

  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    solve(nums, 0, temp);
    return result;
  }

  public static void main(String[] args) {
    SubsetsMedium solver = new SubsetsMedium();
    System.out.println(solver.subsets(new int[] { 1, 2, 3 }));
  }
}
