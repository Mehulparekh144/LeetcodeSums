public class SameTreeEasy {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null){
      return true;
    }
    if(p == null || q == null){
      return false;
    }
    if(p.val != q.val){
      return false;
    }
    return isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    TreeNode p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(3);

    // Creating second tree
    TreeNode q = new TreeNode(1);
    q.left = new TreeNode(2);
    q.right = new TreeNode(3);

    SameTreeEasy solver = new SameTreeEasy();
    System.out.println(solver.isSameTree(p,q));
  }
}
