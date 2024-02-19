import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionMedium {

  public List<Integer> partitionLabels(String s) {
    HashMap<Character , Integer> map = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i) , i);
    }

    int size = 0;
    int end = 0 ;

    for (int i = 0; i < s.length(); i++) {
      size += 1;
      end = Math.max(end , map.get(s.charAt(i)));
      if(i == end){
        result.add(size);
        size = 0;
      }
    }

    return result;
  }
  public static void main(String[] args) {
    PartitionMedium solver = new PartitionMedium();
    String s = "ababcbacadefegdehijhklij";
    System.out.println(solver.partitionLabels(s));


  }
}
