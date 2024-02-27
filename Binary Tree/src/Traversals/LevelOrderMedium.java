package Traversals;

import java.util.*;

public class LevelOrderMedium {
  public List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
      List<Integer> temp = new ArrayList<>();
      int length = queue.size();
      while(length > 0){
        TreeNode node = queue.poll();
        temp.add(node.val);
        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
        length --;
      }
      result.add(temp);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    LevelOrderMedium solver = new LevelOrderMedium();
    System.out.println(solver.levelOrder(root));
  }
}
