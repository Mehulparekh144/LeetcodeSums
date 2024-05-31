public class SetIthBit {
  
  public int setIthBit(int num , int i ){
    return (num | (1 << i));
  }

  public static void main(String[] args) {
    SetIthBit obj = new SetIthBit();
    System.out.println(obj.setIthBit(9, 2));
    System.out.println(obj.setIthBit(9, 3));
  }
}
