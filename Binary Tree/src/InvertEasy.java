public class InvertEasy {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode leftChild = new TreeNode(2);
    TreeNode rightChild = new TreeNode(3);
    TreeNode leftGrandChild = new TreeNode(4);
    TreeNode rightGrandChild = new TreeNode(5);

    // Connecting the nodes to form the binary tree
    root.left = leftChild;
    root.right = rightChild;
    leftChild.left = leftGrandChild;
    leftChild.right = rightGrandChild;

    root.printInorder();
    InvertEasy solver = new InvertEasy();
    System.out.println(solver.invertTree(root));
    root.printInorder();

  }
}
