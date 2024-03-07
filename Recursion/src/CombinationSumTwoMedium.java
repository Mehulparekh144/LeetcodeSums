import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwoMedium {
  List<List<Integer>> result;

  public void solve(int target, int[] candidates, int i, ArrayList<Integer> temp) {
    if (target == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }

    for (int j = i; j < candidates.length; j++) {
      if (j > i && candidates[j] == candidates[j - 1])
        continue;
      if (candidates[j] <= target) {
        temp.add(candidates[j]);
        solve(target - candidates[j], candidates, j + 1, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    result = new ArrayList<>();
    Arrays.sort(candidates); // Sort it Important !
    solve(target, candidates, 0, new ArrayList<>());
    return result;
  }

  public static void main(String[] args) {
    CombinationSumTwoMedium solver = new CombinationSumTwoMedium();
    System.out.println(solver.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
  }
}
