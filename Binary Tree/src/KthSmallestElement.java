import java.util.Stack;

public class KthSmallestElement {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    int n = 0;

    while (current != null || !stack.isEmpty()) {
      while(current != null){
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      n+= 1;
      if (k == n) {
        return current.val;
      }
      current = current.right;
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    KthSmallestElement solver = new KthSmallestElement();
    System.out.println(solver.kthSmallest(root, 3));
  }
}
