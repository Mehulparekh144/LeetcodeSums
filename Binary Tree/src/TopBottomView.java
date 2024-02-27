import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopBottomView {

  public ArrayList<Integer> topView(TreeNode root){
    if(root == null) return new ArrayList<>();
    Queue<AbstractMap.SimpleEntry<TreeNode , Integer>> q = new LinkedList<>();
    q.add(new AbstractMap.SimpleEntry<>(root , 0));
    Map<Integer , Integer> map = new TreeMap<>();
    while(!q.isEmpty()){
      AbstractMap.SimpleEntry<TreeNode , Integer> pair = q.poll();
      TreeNode node = pair.getKey();
      Integer hd = pair.getValue();
      if(!map.containsKey(hd)){
        map.put(hd , node.val);
      }

      if(node.left != null){
        q.add(new AbstractMap.SimpleEntry<>(node.left , hd - 1));
      }
      if(node.right != null){
        q.add(new AbstractMap.SimpleEntry<>(node.right , hd + 1));
      }
    }
    return new ArrayList<>(map.values());
  }
  public ArrayList<Integer> bottomView(TreeNode root){
    if(root == null) return new ArrayList<>();
    Queue<AbstractMap.SimpleEntry<TreeNode , Integer>> q = new LinkedList<>();
    q.add(new AbstractMap.SimpleEntry<>(root , 0));
    Map<Integer , Integer> map = new TreeMap<>();
    while(!q.isEmpty()){
      AbstractMap.SimpleEntry<TreeNode , Integer> pair = q.poll();
      TreeNode node = pair.getKey();
      Integer hd = pair.getValue();
      map.put(hd , node.val);


      if(node.left != null){
        q.add(new AbstractMap.SimpleEntry<>(node.left , hd - 1));
      }
      if(node.right != null){
        q.add(new AbstractMap.SimpleEntry<>(node.right , hd + 1));
      }
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    TreeNode balancedRoot = new TreeNode(10);
    balancedRoot.left = new TreeNode(20);
    balancedRoot.right = new TreeNode(30);
    balancedRoot.left.left = new TreeNode(40);
    balancedRoot.left.right = new TreeNode(60);

    TopBottomView solver = new TopBottomView();
    System.out.println(solver.topView(balancedRoot));
    System.out.println(solver.bottomView(balancedRoot));
  }
}
