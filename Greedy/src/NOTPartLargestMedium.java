import java.util.Arrays;

public class NOTPartLargestMedium {

  public String largestNumber(int[] nums) {
    int n = nums.length;
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = String.valueOf(nums[i]);
    }
    System.out.println(Arrays.asList(s));
    Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
    System.out.println(Arrays.asList(s));
    StringBuilder sb = new StringBuilder();
    for (String str : s) {
      sb.append(str);
    }

    String result = sb.toString();
    return result.startsWith("0") ? "0" : result;
  }

  public static void main(String[] args) {
    NOTPartLargestMedium solver = new NOTPartLargestMedium();
    System.out.println(solver.largestNumber(new int[]{3,30,34,5,9}));
    
  }
}
