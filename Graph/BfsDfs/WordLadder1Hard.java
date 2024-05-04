package BfsDfs;
import java.util.*;
public class WordLadder1Hard {

  class Pair{
    String word;
    int length;

    public Pair(String word , int length){
      this.word = word;
      this.length = length;
    }
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(beginWord, 1));
    set.remove(beginWord);
    int minLength = Integer.MAX_VALUE;
    while(!q.isEmpty()){
      Pair p = q.poll();
      String word = p.word;
      int length = p.length;

      if(Objects.equals(word, endWord)){
        minLength = Math.min(minLength , length);
        return minLength;
      }

      for(int i = 0 ; i < word.length() ; i++){
        StringBuilder sb = new StringBuilder(word);
        for(char c = 'a' ; c <= 'z' ; c++){
          sb.setCharAt(i , c);

          if(set.contains(sb.toString())){
            q.offer(new Pair(sb.toString() , length + 1));
            set.remove(sb.toString());
          }
        }
      }
    }
    return 0;
  }


  public static void main(String[] args) {
    WordLadder1Hard obj = new WordLadder1Hard();
//    System.out.println(obj.ladderLength("hit" , "cog" ,
//            Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    System.out.println(obj.ladderLength("a" , "c" ,
            Arrays.asList(new String[]{"a" , "b" , "c"})));
  }
}
