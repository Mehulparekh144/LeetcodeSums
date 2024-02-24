package Traversals;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversals {

  public void preOrderHelper(TreeNode root , List<Integer> result){
    if(root == null){
      return;
    }
    result.add(root.val);
    preOrderHelper(root.left , result);
    preOrderHelper(root.right , result);
  }
  public List<Integer> preOrderRecursive(TreeNode root){
    List<Integer> result =new ArrayList<>();
    preOrderHelper(root, result);
    return result;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(-2);
    root.left.left.right = new TreeNode(2);
    root.left.left.right.left = new TreeNode(-1);
    root.left.right = new TreeNode(6);
    root.left.right.right = new TreeNode(8);
    root.right = new TreeNode(30);
    root.right.right = new TreeNode(40);

    PreorderTraversals preorderTraversals =new PreorderTraversals();
    System.out.println(preorderTraversals.preOrderRecursive(root));
  }
}
