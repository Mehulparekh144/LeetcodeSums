import java.util.HashMap;
import java.util.PriorityQueue;

public class HandOfStraightMedium {
  
  public boolean isNStraightHand(int[] hand , int groupSize){
    if(hand.length % groupSize != 0){
      return false;
    }
    HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();
    for (int i = 0; i < hand.length; i++) {
      if (count.containsKey(hand[i])) {
        count.put(hand[i] , count.get(hand[i]) + 1);        
      }
      else{
        count.put(hand[i] , 1);
      }
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    for(Integer key : count.keySet()){
      minHeap.add(key);
    }

    while (minHeap.size() != 0){
      Integer first = minHeap.peek();
      for (int i = first; i < first + groupSize; i++) {
        if(!count.containsKey(i)){
          return false;
        }
        count.put(i , count.get(i) - 1);
        if(count.get(i) == 0){
          if(i != minHeap.peek()){
            return false;
          }
          minHeap.remove(i);
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    HandOfStraightMedium solver = new HandOfStraightMedium();
    System.out.println(solver.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
  }
}
