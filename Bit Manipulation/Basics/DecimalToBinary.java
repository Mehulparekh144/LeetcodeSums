public class DecimalToBinary{

  public String decimalToBinary(int n){
    if(n == 0){
      return "0";
    }

    StringBuilder ans = new StringBuilder();
    while(n != 1){
      if(n % 2 == 0){
        ans.append("0");
      } else{
        ans.append("1");
      }
      n = n/2;
    }
    ans.append("1");
    ans.reverse();
    return ans.toString();
  }

  public static void main(String[] args) {
    DecimalToBinary obj = new DecimalToBinary();
    System.out.println(obj.decimalToBinary(7));
    System.out.println(obj.decimalToBinary(2));
    System.out.println(obj.decimalToBinary(13));
  }
}