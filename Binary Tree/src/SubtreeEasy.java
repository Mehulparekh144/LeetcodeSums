public class SubtreeEasy {

  public boolean helper(TreeNode root , TreeNode subRoot){
    if(root == null && subRoot == null) {
      return true;
    }
    if(root != null && subRoot != null && root.val == subRoot.val){
      return  helper(root.left , subRoot.left) && helper(root.right , subRoot.right);
    }
    return false;
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot){
    if(subRoot == null){
      return true;
    }
    if(root == null){
      return false;
    }
    if(helper(root , subRoot)){
      return true;
    }
     return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
    }

  public static void main(String[] args) {

  }
}
