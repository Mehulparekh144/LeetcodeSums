package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversals {

  public void inOrderHelper(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    inOrderHelper(root.left, result);
    result.add(root.val);
    inOrderHelper(root.right, result);
  }

  // Recursive
  public List<Integer> inorderTraversalRecursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inOrderHelper(root, result);
    return result;
  }

  // Iterative
  public List<Integer> inOrderTraversalIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (true) {
      if (node != null) {
        stack.add(node);
        node = node.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        node = stack.pop();
        result.add(node.val);
        node = node.right;
      }

    }

    return result;
  }

  // Morris
  public List<Integer> inOrderTraversalMorris(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;
    while (current != null) {
      if (current.left == null) {
        result.add(current.val);
        current = current.right;
      } else {
        // Find predecessor which is rightmost child of left subtree
        TreeNode predecessor = current.left;
        while (predecessor.right != current && predecessor.right != null) {
          predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
          predecessor.right = current;
          current = current.left;
        } else {
          predecessor.right = null;
          result.add(current.val);
          current = current.right;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Create a binary tree
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(-2);
    root.left.left.right = new TreeNode(2);
    root.left.left.right.left = new TreeNode(-1);
    root.left.right = new TreeNode(6);
    root.left.right.right = new TreeNode(8);
    root.right = new TreeNode(30);
    root.right.right = new TreeNode(40);


    // Perform inorder traversal
    InorderTraversals inorderTraversals = new InorderTraversals();
    // List<Integer> result = inorderTraversals.inorderTraversalRecursive(root);
    // List<Integer> result = inorderTraversals.inOrderTraversalIterative(root);
    List<Integer> result = inorderTraversals.inOrderTraversalMorris(root);

    // Print the result
    System.out.println(result);
  }
}
