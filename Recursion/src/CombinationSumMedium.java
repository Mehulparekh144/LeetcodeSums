import java.util.ArrayList;
import java.util.List;

public class CombinationSumMedium {
  List<List<Integer>> result;

  public void solve(int[] candidates, int target, int i, List<Integer> temp) {
    if (i == candidates.length) {
      if (target == 0) {
        result.add(new ArrayList<>(temp));
      }
      return;
    }

    // Choose
    if (candidates[i] <= target) {
      temp.add(candidates[i]);
      solve(candidates, target - candidates[i], i, temp);
      temp.remove(temp.size() - 1);
    }
    // Not choose
    solve(candidates, target, i + 1, temp);
    }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    result = new ArrayList<>();
    solve(candidates, target, 0, new ArrayList<>());
    return result;
  }

  public static void main(String[] args) {
    CombinationSumMedium solver = new CombinationSumMedium();
    System.out.println(solver.combinationSum(new int[] { 1, 2, 3 }, 4));
  }
}