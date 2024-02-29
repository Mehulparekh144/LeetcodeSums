import java.util.AbstractMap;
import java.util.Arrays;

public class ConstructBinaryTreeInorderPreorder {
  int idx = 0;
  public TreeNode buildTree(int[] preorder , int[] inorder){
    return helper(preorder , inorder , 0 , preorder.length );
  }

  public TreeNode helper(int[] preorder , int[] inorder , int left , int right ){
    if(idx == preorder.length || left > right){
      return null;
    }
    TreeNode root = new TreeNode(preorder[idx]);
    for (int i = left; i <= right ; i++) {
      if(preorder[idx] == inorder[i]){
        idx ++;

        root.left = helper(preorder , inorder , left , i - 1 );
        root.right = helper(preorder , inorder , i + 1 , right);
        break;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    int [] preorder = new int[]{3,9,20,15,7};
    int [] inorder = new int[]{9,3,15,20,7};

    ConstructBinaryTreeInorderPreorder solver = new ConstructBinaryTreeInorderPreorder();
    System.out.println(solver.buildTree(preorder , inorder));
  }
}
