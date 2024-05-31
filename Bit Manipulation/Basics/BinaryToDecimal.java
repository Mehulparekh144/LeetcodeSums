public class BinaryToDecimal {
  
  public int binaryToDecimal(String binary){
    int ans = 0;
    int power = 0;
    for(int i = binary.length() - 1 ; i >= 0 ; i-- ){
      if(binary.charAt(i) == '1'){
        ans += Math.pow(2 , power);
      }
      power++;
    }

    return ans;
  }

  public static void main(String[] args) {
    BinaryToDecimal obj = new BinaryToDecimal();
    System.out.println(obj.binaryToDecimal("111"));
    System.out.println(obj.binaryToDecimal("10"));
    System.out.println(obj.binaryToDecimal("1101"));
  }
}
