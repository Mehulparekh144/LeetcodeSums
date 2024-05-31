public class CountNumberOfSetBits {
  
  public int countSetBits(int num){
    int count = 0;
    while(num > 1){
      // if(num%2 == 1) count++;
      count += num & 1;
      // num /= 2;
      num >>= 1;
    }
    if(num == 1) count++;
    return count;
  }


  public int countSetBitsSecond(int num){
    int count = 0;
    while(num != 0){
      num = num & num - 1;
      count++;
    }

    return count;
  }
}
