public class IthBitSet {
  
  public boolean isBitSetLeftShift(int num , int  i){
    return (num & (1 << i)) != 0;
  }

  public boolean isBitSetRightShift(int num, int i) {
    return ((num >> i) & 1) != 0;
  }

  public static void main(String[] args) {
    IthBitSet obj = new IthBitSet();
    System.out.println(obj.isBitSetLeftShift(13, 2));
    System.out.println(obj.isBitSetLeftShift(6,1));
    System.out.println(obj.isBitSetLeftShift(6,0));

    System.out.println(obj.isBitSetRightShift(13, 2));
    System.out.println(obj.isBitSetRightShift(6,1));
    System.out.println(obj.isBitSetRightShift(6,0));
  }
}
