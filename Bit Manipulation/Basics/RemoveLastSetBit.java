public class RemoveLastSetBit {
  
  public int removeLastSetBit(int num){
    return num & (num -1);
  }

  public static void main(String[] args) {
    RemoveLastSetBit obj = new RemoveLastSetBit();
    System.out.println(obj.removeLastSetBit(40));
  }
}
