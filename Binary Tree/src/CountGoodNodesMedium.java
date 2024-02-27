import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

public class CountGoodNodesMedium {

  public int dfs(TreeNode root , int max){
    if(root == null) return 0;
    int res = root.val >= max ? 1 : 0;
    max = Math.max(max , root.val);
    res += dfs(root.left , max);
    res += dfs(root.right , max);
    return res;
  }
  public int goodNodes(TreeNode root) {
    // Recursive
//    return dfs(root , root.val);

    //Iterative
    Queue<AbstractMap.SimpleEntry<TreeNode , Integer>> q = new LinkedList<>();
    q.add(new AbstractMap.SimpleEntry<>(root , Integer.MIN_VALUE));
    int ans = 0;
    while(!q.isEmpty()){
      AbstractMap.SimpleEntry<TreeNode , Integer> pair = q.poll();
      TreeNode node = pair.getKey();
      int max = pair.getValue();
      if(node.val >= max){
        ans += 1;
      }
      max = Math.max(max , node.val);

      if(node.left != null){
        q.add(new AbstractMap.SimpleEntry<>(node.left , max));
      }
      if(node.right != null){
        q.add(new AbstractMap.SimpleEntry<>(node.right , max));
      }
    }

    return ans;
  }

}
