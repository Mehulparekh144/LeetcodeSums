import java.util.ArrayList;
import java.util.Stack;

public class CarFleetMedium {
  public int carFleet(int target, int[] position, int[] speed) {
    ArrayList<ArrayList<Integer>> carState = new ArrayList<>();
    for (int i = 0; i < position.length; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(target - position[i]);
      temp.add(speed[i]);
      carState.add(temp);
    }
    carState.sort((a, b) -> (a.get(0) - b.get(0)));
    Stack<Double> stack = new Stack<>();
    stack.add((double)carState.get(0).get(0) / carState.get(0).get(1));

    for (int i = 1; i < carState.size(); i++) {
      double currTime = (double)carState.get(i).get(0)/carState.get(i).get(1);
      if (currTime > stack.peek()) {
        stack.add(currTime);
      }
    }
    return stack.size();
  }

  public static void main(String[] args) {
    CarFleetMedium solver = new CarFleetMedium();
    System.out.println(solver.carFleet(10, new int[] { 6, 8 }, new int[] { 3, 2 }));
  }
}
