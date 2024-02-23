public class MaxDepthEasy {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = root.left != null ? maxDepth(root.left) : 0;
    int rightDepth = root.right != null ? maxDepth(root.right) : 0;
    return Math.max(leftDepth , rightDepth) + 1;
  }

  public static void main(String[] args) {
      // Create a binary tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      // Calculate the maximum depth
      MaxDepthEasy maxDepthEasy = new MaxDepthEasy();
      int maxDepth = maxDepthEasy.maxDepth(root);

      // Print the result
      System.out.println("Maximum depth of the binary tree: " + maxDepth);
    }
    
}
