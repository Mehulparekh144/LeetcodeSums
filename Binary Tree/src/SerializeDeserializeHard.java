import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SerializeDeserializeHard {
  public static class Codec {

    List<String> result;
    int i;
    private void dfs(TreeNode root){
      if(root == null){
        result.add("N");
        return;
      }
      result.add(String.valueOf(root.val));
      dfs(root.left);
      dfs(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      result = new ArrayList<>();
      dfs(root);
      return String.join("," , result);
    }

    private TreeNode dfs(String[] values){
      if(Objects.equals(values[i], "N")){
        i += 1;
        return null;
      }
      TreeNode node = new TreeNode(Integer.parseInt(values[i]));
      i += 1;
      node.left = dfs(values);
      node.right = dfs(values);
      return node;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] values = data.split(",");
      i = 0;
      return dfs(values);
    }
  }

  public static void main(String[] args) {
    Codec solver = new Codec();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    System.out.println(solver.serialize(root));
  }

}
