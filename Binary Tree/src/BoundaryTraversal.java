import com.github.afkbrb.btp.BTPrinter;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {


  public boolean isLeaf(TreeNode root){
    return root.left == null && root.right == null;
  }
  public void leftBoundary(TreeNode root , List<Integer> result){
    TreeNode curr = root;
    while(curr != null){
      if(!isLeaf(curr)){
        result.add(curr.val);
      }
       if(curr.left != null){
        curr = curr.left;
      } else{
        curr = curr.right;
      }
    }
  }

  public void leafNodes(TreeNode root , List<Integer> result){
    if(isLeaf(root)){
      result.add(root.val);
      return;
    }
    if(root.left != null){
      leafNodes(root.left , result);
    }
    if(root.right != null){
      leafNodes(root.right , result);
    }
  }

  public void rightBoundary(TreeNode root, List<Integer> result){
    List<Integer> temp = new ArrayList<>();
    TreeNode curr = root;
    while(curr != null){
      if(!isLeaf(curr)){
        temp.add(curr.val);
      }
      if(curr.right != null){
        curr = curr.right;
      }
      else{
        curr = curr.left;
      }
    }

    for (int i = temp.size() - 1 ; i > -1 ; i--) {
      result.add(temp.get(i));
    }
  }
  public List<Integer> boundaryTraversal(TreeNode root){
    List<Integer> result = new ArrayList<>();
    leftBoundary(root , result);
    leafNodes(root , result);
    rightBoundary(root,result);
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(4);
    root.left.left.right.left = new TreeNode(5);
    root.left.left.right.right = new TreeNode(6);

    root.right = new TreeNode(7);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    root.right.right.left.left = new TreeNode(10);
    root.right.right.left.right = new TreeNode(11);


    BoundaryTraversal solver = new BoundaryTraversal();
    System.out.println(solver.boundaryTraversal(root));
  }
}
