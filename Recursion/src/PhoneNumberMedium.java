import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMedium {
    List<String> result;
    Map<String,String> map;
    public void solve(int i , String digits ,String s){
      if(s.length() == digits.length() ){
        result.add(s);
        return;
      }
      String str = map.get(String.valueOf(digits.charAt(i)));
      for(char c : str.toCharArray()){
        solve(i + 1 , digits , s + c );
      }
    }
    
    public List<String> letterCombinations(String digits) {
      result = new ArrayList<>();
      map = new HashMap<>();
      map.put("2" , "abc");
      map.put("3" , "def");
      map.put("4" , "ghi");
      map.put("5" , "jkl");
      map.put("6" , "mno");
      map.put("7" , "pqrs");
      map.put("8" , "tuv");
      map.put("9" , "wxyz");
      if(digits.isEmpty()){
        return result;
      }
      solve(0 , digits , "");
      return result;
    }

    public static void main(String[] args) {
      PhoneNumberMedium solver = new PhoneNumberMedium();
      System.out.println(solver.letterCombinations("23"));
    }
}

