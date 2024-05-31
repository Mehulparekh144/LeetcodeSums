public class ToggleIthBit {
  
  public int toggle(int num , int i ){
    return num ^ (1 << i);
  }

  public static void main(String[] args) {
    ToggleIthBit obj = new ToggleIthBit();
    System.out.println(obj.toggle(13,2));
    System.out.println(obj.toggle(13 , 1));
  }
}
