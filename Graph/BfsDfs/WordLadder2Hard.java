package BfsDfs;

import java.util.*;

public class WordLadder2Hard {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    Queue<List<String>> q = new LinkedList<>();
    List<String> temp = new ArrayList<>();
    temp.add(beginWord);
    q.offer(temp);
    int level = 0 ;
    List<String> usedOnLevel = new ArrayList<>();
    Set<String> set = new HashSet<>(wordList);
    set.remove(beginWord);

    while(!q.isEmpty()){
      List<String> words = q.poll();

      if(words.size() > level){
        level+=1;
        for(String word : words){
          set.remove(word);
        }
      }

      String word = words.getLast();
      if(Objects.equals(word, endWord)){
        if(result.isEmpty()){
          result.add(words);
        } else if(result.getFirst().size() == words.size()){
          result.add(words);
        }
      }

      for(int i = 0 ; i < word.length() ; i++){
        StringBuilder sb = new StringBuilder(word);
        for(char c = 'a' ; c <= 'z' ; c++){
          sb.setCharAt(i , c);

          if(set.contains(sb.toString())){
            words.add(sb.toString());
            q.offer(new ArrayList<>(words));
            usedOnLevel.add(sb.toString());
            words.removeLast();
          }
        }
      }
    }

    return result;

  }

  public static void main(String[] args) {
    WordLadder2Hard obj = new WordLadder2Hard();
    System.out.println(obj.findLadders("hit" , "cog" ,
            List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog" })));
  }
}
