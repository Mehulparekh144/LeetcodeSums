public class ClearIthBit {

  public int clearBit(int num , int i ){
    return num & (~(1 << i));
  }

  public static void main(String[] args) {
    ClearIthBit obj = new ClearIthBit();
    System.out.println(obj.clearBit(9, 3));
    System.out.println(obj.clearBit(13, 2));
  }
}
