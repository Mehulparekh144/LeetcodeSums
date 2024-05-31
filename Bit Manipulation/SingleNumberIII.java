public class SingleNumberIII {
  public int[] singleNumber(int[] nums) {
    int xor = 0;

    for (int num : nums) {
      xor ^= num;
    }

    int diffBit = xor & (-xor);
    int a = 0;
    int b = 0;

    for (int num : nums) {
      if ((diffBit & num) == 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }

    return new int[] { a, b };
  }

  public static void main(String[] args) {
    SingleNumberIII obj = new SingleNumberIII();
    obj.singleNumber(new int[]{1,2,1,3,2,5});
  }
}
