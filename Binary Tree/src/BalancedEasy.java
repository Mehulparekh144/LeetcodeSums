public class BalancedEasy {

//  public int depth(TreeNode root){
//    if(root == null){
//      return 0;
//    }
//    int leftHeight = depth(root.left);
//    int rightHeight = depth(root.right);
//    return Math.max(leftHeight , rightHeight) + 1;
//  }

  public int checkBalance(TreeNode root){
    if(root == null){
      return 0;
    }

    int leftHeight = checkBalance(root.left);
    if(leftHeight == -1){
      return -1;
    }

    int rightHeight = checkBalance(root.right);
    if(rightHeight == -1){
      return -1;
    }

    if(Math.abs(leftHeight - rightHeight) > 1){
      return -1;
    }
    return Math.max(leftHeight , rightHeight) + 1;
  }

  public boolean isBalanced(TreeNode root){
    return checkBalance(root) != -1;

    // BRUTE
//    if(root == null){
//      return true;
//    }
//    int leftHeight = root.left == null ? 0 : depth(root.left);
//    int rightHeight = root.right == null ? 0 : depth(root.right);
//    if (Math.abs(leftHeight - rightHeight) > 1) {
//      return false;
//    }
//
//    boolean left = isBalanced(root.left);
//    boolean right = isBalanced(root.right);
//    return left && right;
  }

  public static void main(String[] args) {
    // Create a balanced binary tree
    TreeNode balancedRoot = new TreeNode(1);
    balancedRoot.left = new TreeNode(2);
    balancedRoot.right = new TreeNode(3);
    balancedRoot.left.left = new TreeNode(4);
    balancedRoot.left.right = new TreeNode(5);
    balancedRoot.right.left = new TreeNode(6);
    balancedRoot.right.right = new TreeNode(7);

    // Create an unbalanced binary tree
    TreeNode unbalancedRoot = new TreeNode(1);
    unbalancedRoot.left = new TreeNode(2);
    unbalancedRoot.right = new TreeNode(3);
    unbalancedRoot.left.left = new TreeNode(4);
    unbalancedRoot.left.left.left = new TreeNode(5);

    BalancedEasy solver = new BalancedEasy();
    System.out.println(solver.isBalanced(balancedRoot));
    System.out.println(solver.isBalanced(unbalancedRoot));

  }
}
