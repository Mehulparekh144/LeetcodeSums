package topoSort;
import java.util.*;

public class AlienDictionaryMedium {

  private static void bfs(List<List<Integer>> adj , List<Integer> res){
    Queue<Integer> q = new LinkedList<>();
    int[] indegree = new int[adj.size()];
    for(int i = 0 ; i < adj.size() ; i++){
      for(int child : adj.get(i)){
        indegree[child]++;
      }
    }

    for(int i = 0 ; i < adj.size() ; i++){
      if(indegree[i] == 0){
        q.offer(i);
      }
    }

    while(!q.isEmpty()){
      int node = q.poll();
      res.add(node);

      for(int child : adj.get(node)){
        if(--indegree[child] == 0){
          q.offer(child);
        }
      }
    }


  }
  public static String getAlienLanguage(String []dictionary, int k) {
    // Write your code here.
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0 ; i < k ; i++){
      adj.add(new ArrayList<>());
    }
    for(int i = 0 ; i < dictionary.length - 1 ; i++){
      String s1 = dictionary[i];
      String s2 = dictionary[i+1];
      int len = Math.min(s1.length() , s2.length());

      for(int j = 0 ; j < len ; j++){
        if(s1.charAt(j) != s2.charAt(j)){
          adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
          break;
        }
      }
    }

    List<Integer> res = new ArrayList<>();
    bfs(adj , res);

    StringBuilder sb = new StringBuilder();
    for(int c : res){
      sb.append((char) (c + (int) 'a'));
    }
    System.out.println(sb.toString());
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(getAlienLanguage(new String[]{"bbbbc" , "bba" , "aaaaac"} , 3));
  }
}
