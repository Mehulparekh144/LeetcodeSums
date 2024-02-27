import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidBSTMedium {

//  public void inOrder(TreeNode root , List<Integer> result){
//    if(root == null) return;
//    inOrder(root.left , result);
//    result.add(root.val);
//    inOrder(root.right , result);
//  }
//
//  public boolean isSorted(List<Integer> list){
//    for (int i = 1; i < list.size(); i++) {
//      if(list.get(i - 1) >= list.get(i)){
//        return false;
//      }
//    }
//    return true;
//  }

  public boolean dfs(TreeNode root , long min , long max){
    if (root == null)  return true;
    if(root.val <= min || root.val > max){
      return false;
    }

    boolean left = dfs(root.left , min , root.val);
    boolean right = dfs(root.right , root.val , max);
    return left && right;
  }
  public boolean isValidBST(TreeNode root){
    return dfs(root , Long.MIN_VALUE , Long.MAX_VALUE);
//    List<Integer> result = new ArrayList<>();
//    inOrder(root , result);
//
//    if(result.stream().distinct().count() != result.size()) return false;
//    return isSorted(result);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2147483647);
    ValidBSTMedium solver = new ValidBSTMedium();
    System.out.println(solver.isValidBST(root));

  }
}
