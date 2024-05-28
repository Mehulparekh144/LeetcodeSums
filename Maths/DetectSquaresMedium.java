import java.util.*;
public class DetectSquaresMedium {
  Map<String, Integer> map;
  List<int[]> points;

  public DetectSquaresMedium() { 
    map = new HashMap<>();
    points = new ArrayList<>();
  }

  public void add(int[] point) {
    String key = point[0] + "#" + point[1];
    if (!map.containsKey(key)) {
      points.add(point);
    }
    map.put(key, map.getOrDefault(key, 0) + 1);
  }

  public int count(int[] point) {
    int px = point[0];
    int py = point[1];
    int ans = 0;

    for (int[] dpoint : points) {
      int x = dpoint[0];
      int y = dpoint[1];

      int dx = Math.abs(x - px);
      int dy = Math.abs(y - py);

      if (x != px && y != py && dx == dy) {
        if (map.containsKey(x + "#" + py) && map.containsKey(px + "#" + y)) {
          ans += map.get(x + "#" + py) * map.get(px + "#" + y) * map.get(x + "#" + y);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    DetectSquaresMedium obj = new DetectSquaresMedium();
    obj.add(new int[]{3, 10});
    obj.add(new int[]{11, 2});
    obj.add(new int[]{3, 2});
    int count = obj.count(new int[]{11, 10});
    System.out.println("Count: " + count);
        
  }
}
