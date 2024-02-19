import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMapMedium {
  private Map<String, List<List<Object>>> map;

  public TimeMapMedium() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if(!map.containsKey(key)){
      map.put(key , new ArrayList<>());
    }
    List<Object> temp = new ArrayList<>();
    temp.add(value);
    temp.add(timestamp);
    map.get(key).add(temp);
  }

  public String get(String key, int timestamp) {
    String res = "";
    List<List<Object>> values = map.getOrDefault(key, new ArrayList<>());
    int l = 0 ;
    int r = values.size() - 1;

    while(l <= r){
      int m = l + (r-l)/2;

      if((int) values.get(m).get(1) <= timestamp){
        res = (String) values.get(m).get(0);
        l = m + 1;
      }
      else{
        r = m - 1;
      }
    }

    return res;
  }

}
