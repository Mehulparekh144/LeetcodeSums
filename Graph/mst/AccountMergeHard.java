package mst;
import java.util.*;

public class AccountMergeHard {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> map = new TreeMap<>();
    DisjointSet ds = new DisjointSet(accounts.size());
    for (int i = 0; i < accounts.size(); i++) {
      for (int j = 1; j < accounts.get(i).size(); j++) {
        if (!map.containsKey(accounts.get(i).get(j))) {
          map.put(accounts.get(i).get(j), i);
        } else {
          ds.unionBySize(i, map.get(accounts.get(i).get(j)));
        }
      }
    }

    Map<Integer, List<String>> merged = new HashMap<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String email = entry.getKey();
      int idx = ds.findUPar(entry.getValue());
      merged.computeIfAbsent(idx , k -> new ArrayList<>()).add(email);
    }

    System.out.println(merged);

    List<List<String>> res = new ArrayList<>();
    for (Map.Entry<Integer, List<String>> entry : merged.entrySet()) {
      String name = accounts.get(entry.getKey()).get(0);
      List<String> temp = new ArrayList<>();
      temp.add(name);
      Collections.sort(entry.getValue());
      temp.addAll(entry.getValue());
      res.add(temp);

    }

    return res;
  }

  public static void main(String[] args) {
      AccountMergeHard obj = new AccountMergeHard();
    List<List<String>> accounts = new ArrayList<>();
    accounts.add(Arrays.asList("Hanzo", "Hanzo2@m.co", "Hanzo3@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo4@m.co", "Hanzo5@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo4@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo7@m.co", "Hanzo8@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo1@m.co", "Hanzo2@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo6@m.co", "Hanzo7@m.co"));
    accounts.add(Arrays.asList("Hanzo", "Hanzo5@m.co", "Hanzo6@m.co"));
    System.out.println(obj.accountsMerge(accounts));

  }

}
