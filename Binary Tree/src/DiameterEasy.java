
public class DiameterEasy {

  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root){
    diameterSolver(root);
    return this.diameter;
  }

  public int diameterSolver(TreeNode root){
    int left = root.left != null ? diameterSolver(root.left ) : 0;
    int right = root.right != null ? diameterSolver(root.right ) : 0;

    this.diameter = Math.max(this.diameter , left + right );
    return Math.max(left , right) + 1;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    DiameterEasy solver = new DiameterEasy();
    System.out.println(solver.diameterOfBinaryTree(root));
  }
}
