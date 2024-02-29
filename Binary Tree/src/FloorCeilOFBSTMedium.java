public class FloorCeilOFBSTMedium {

  public int ceilInBST(TreeNode node , int x){
    int ceil = -1;
    while(node != null){
      if(node.val == x){
        ceil = node.val;
        return ceil;
      }
      if(x > node.val){
        node = node.right;
      }
      else{
        ceil = node.val;
        node = node.left;
      }
    }
    return ceil;
  }
  public int floorInBST(TreeNode root , int X){
    int floor = -1;

    while(root != null){
      if(root.val == X){
        floor = root.val;
        return floor;
      }
      if(X > root.val){
        floor = root.val;
        root = root.right;
      }
      else{
        root = root.left;
      }
    }

    return floor;
  }
}
