package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversals {

//  public void postOrderHelper(TreeNode root , List<Integer> result){
//    if(root == null){
//      return;
//    }
//    postOrderHelper(root.left,result);
//    postOrderHelper(root.right,result);
//    result.add(root.val);
//  }
//  public List<Integer> postOrderRecursive(TreeNode root){
//    List<Integer> result = new ArrayList<>();
//    postOrderHelper(root , result);
//    return result;
//  }
  public List<Integer> postOrderIterative(TreeNode root){
    List<Integer> result = new ArrayList<>();
    if(root == null){
      return result;
    }
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);
    while(!stack1.isEmpty()){
      root = stack1.pop();
      stack2.push(root);
      if(root.left != null){
        stack1.push(root.left);
      }
      if(root.right != null){
        stack1.push(root.right);
      }
    }

    while(!stack2.isEmpty()){
      result.add(stack2.pop().val);
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

    PostOrderTraversals solver = new PostOrderTraversals();
//    System.out.println(solver.postOrderRecursive(root));
    System.out.println(solver.postOrderIterative(root));
  }
}
