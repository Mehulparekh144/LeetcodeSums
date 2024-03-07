import java.util.ArrayList;
import java.util.List;

public class CombinationSumThreeMedium {

  List<List<Integer>> result;

  public void solve(int k, int n, int i, List<Integer> temp) {
    if (i == 9) {
      if (k == 0 && n == 0) {
        result.add(new ArrayList<>(temp));
      }
      return;
    }

    if ((i + 1) <= n && k > 0) {
      temp.add(i + 1);
      solve(k - 1, n - (i + 1), i + 1, temp);
      temp.remove(temp.size() - 1);
    }

    solve(k, n, i + 1, temp);
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    result = new ArrayList<>();
    solve(k, n, 0, new ArrayList<>());
    return result;
  }

  public static void main(String[] args) {
    CombinationSumThreeMedium solver = new CombinationSumThreeMedium();
    System.out.println(solver.combinationSum3(3, 7));
  }
}
