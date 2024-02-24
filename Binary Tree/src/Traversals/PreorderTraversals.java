package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversals {

//  public void preOrderHelper(TreeNode root , List<Integer> result){
//    if(root == null){
//      return;
//    }
//    result.add(root.val);
//    preOrderHelper(root.left , result);
//    preOrderHelper(root.right , result);
//  }
//  public List<Integer> preOrderRecursive(TreeNode root){
//    List<Integer> result =new ArrayList<>();
//    preOrderHelper(root, result);
//    return result;
//  }

//  public List<Integer> preOrderIterative(TreeNode root){
//    List<Integer> result =new ArrayList<>();
//    Stack<TreeNode> stack = new Stack<>();
//    TreeNode current = root;
//    stack.add(current);
//    if(current == null){
//      return result;
//    }
//    while(!stack.isEmpty()){
//      current = stack.pop();
//      result.add(current.val);
//      if(current.right != null){
//        stack.add(current.right);
//      }
//      if(current.left != null){
//        stack.add(current.left);
//      }
//    }
//    return result;
//  }

  public List<Integer> preOrderMorris(TreeNode root){
    TreeNode current = root;
    List<Integer> result = new ArrayList<>();

    while(current != null){
      if(current.left == null){
        result.add(current.val);
        current = current.right;
      }

      else{
        TreeNode predecessor = current.left;
        while(predecessor.right != null && predecessor.right != current ){
          predecessor = predecessor.right;
        }

        if(predecessor.right == null){
          result.add(current.val);
          predecessor.right = current;
          current = current.left;
        }
        else{
          predecessor.right = null;
          current = current.right;
        }
      }
    }
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
//    System.out.println(preorderTraversals.preOrderRecursive(root));
//    System.out.println(preorderTraversals.preOrderIterative(root));
    System.out.println(preorderTraversals.preOrderMorris(root));
  }
}
