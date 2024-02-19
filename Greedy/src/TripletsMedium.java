import java.util.Arrays;
import java.util.HashSet;

public class TripletsMedium {

  public boolean mergeTriplets(int[][] triplets , int[] target) {
    HashSet<Integer> hset = new HashSet<>();
    for(int[] t : triplets){
      if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]){
        continue;
      }
      for (int i = 0; i < t.length; i++) {
        if(t[i] == target[i]){
          hset.add(i);
        }
      }
    }

    return hset.size() == target.length;
  }

  public static void main(String[] args) {
    TripletsMedium solver = new TripletsMedium();
    int[][] triplets = {{2,5,3}, {1,8,4} , {1,7,5}};
    int[] target = {2,7,5};
    System.out.println(solver.mergeTriplets(triplets , target));
  }
}
