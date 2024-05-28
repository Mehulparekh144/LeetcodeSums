public class HappyNumberEasy {
  public boolean isHappy(int n) {
    int slow = n;
    int fast = n;

    do {
      slow = square(slow);
      fast = square(square(fast));
    } while (slow != fast);

    return slow == 1;
  }

  private int square(int n) {
    int res = 0;
    while (n > 0) {
      int digit = n % 10;
      res += digit * digit;
      n = n / 10;
    }

    return res;
  }
}
