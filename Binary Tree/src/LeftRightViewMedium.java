import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeftRightViewMedium {

  public List<Integer> rightSideView(TreeNode root){
    if(root == null) return new ArrayList<>();
    Queue<AbstractMap.SimpleEntry<TreeNode , Integer>> q = new LinkedList<>();
    q.add(new AbstractMap.SimpleEntry<>(root , 0));
    Map<Integer , Integer> map = new HashMap<>();

    while(!q.isEmpty()){
      AbstractMap.SimpleEntry<TreeNode , Integer> pair = q.poll();
      TreeNode node = pair.getKey();
      Integer level = pair.getValue();
      map.put(level , node.val);  // Right View

      if(node.left != null){
        q.add(new AbstractMap.SimpleEntry<>(node.left , level + 1));
      }
      if(node.right != null){
        q.add(new AbstractMap.SimpleEntry<>(node.right , level + 1));
      }
    }
    return new ArrayList<>(map.values());
  }
  public List<Integer> leftSideView(TreeNode root){
    if(root == null) return new ArrayList<>();
    Queue<AbstractMap.SimpleEntry<TreeNode , Integer>> q = new LinkedList<>();
    q.add(new AbstractMap.SimpleEntry<>(root , 0));
    Map<Integer , Integer> map = new HashMap<>();

    while(!q.isEmpty()){
      AbstractMap.SimpleEntry<TreeNode , Integer> pair = q.poll();
      TreeNode node = pair.getKey();
      Integer level = pair.getValue();
      if(!map.containsKey(level)){
        map.put(level , node.val);
      }

      if(node.left != null){
        q.add(new AbstractMap.SimpleEntry<>(node.left , level + 1));
      }
      if(node.right != null){
        q.add(new AbstractMap.SimpleEntry<>(node.right , level + 1));
      }
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    TreeNode balancedRoot = new TreeNode(1);
    balancedRoot.left = new TreeNode(2);
    balancedRoot.right = new TreeNode(3);
    balancedRoot.left.left = new TreeNode(4);
    balancedRoot.left.right = new TreeNode(5);
    balancedRoot.right.left = new TreeNode(6);
    balancedRoot.right.right = new TreeNode(7);
    
    LeftRightViewMedium solver = new LeftRightViewMedium();
    System.out.println(solver.rightSideView(balancedRoot));
    System.out.println(solver.leftSideView(balancedRoot));
  }
}
