public class NumberPowerOf2 {
  
  public boolean isPower(int num){
    return (num & (num - 1)) == 0;
  }

  public static void main(String[] args) {
    NumberPowerOf2 obj = new NumberPowerOf2();
    System.out.println(obj.isPower(4));
    System.out.println(obj.isPower(6));
    System.out.println(obj.isPower(13));
  }
}
