import java.util.Arrays;

public class GasStationMedium {

  public int canCompleteCircuit(int[] gas , int[] cost){
    if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
      return -1;
    }
    int total = 0;
    int start = 0;
    for (int i = 0; i < cost.length; i++) {
      total += gas[i] - cost[i];
      if(total < 0){
        total = 0;
        start = i + 1;
      }
    }

    return start;
    
  }

  public static void main(String[] args) {
    int[] gas ,cost;
    gas = new int[]{1, 2, 3, 4, 5};
    cost = new int[]{3, 4, 5, 1, 2};

    GasStationMedium solver = new GasStationMedium();
    System.out.println(solver.canCompleteCircuit(gas, cost));

    gas = new int[]{2,3,4};
    cost = new int[]{3,4,3};

    System.out.println(solver.canCompleteCircuit(gas, cost));


  }
}
