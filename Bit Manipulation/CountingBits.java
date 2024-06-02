/**
 * This class calculates the number of bits set to 1 in each number from 0 to n.
 */
public class CountingBits {
  
  /**
   * Calculates the number of bits set to 1 in each number from 0 to n.
   * 
   * @param n The upper limit of the range of numbers.
   * @return An array containing the count of bits set to 1 for each number from 0 to n.
   */
  public int[] countBits(int n) {
    int[] ans = new int[n + 1]; // Create an array to store the count of bits set to 1 for each number from 0 to n.
    int offSet = 1; // Initialize the offset to 1.
    for (int i = 1; i <= n; i++) { // Iterate through each number from 1 to n.
      if (offSet * 2 == i) { // Check if the current number is a power of 2.
        offSet = i; // Update the offset to the current number.
      }
      ans[i] = 1 + ans[i - offSet]; // Calculate the count of bits set to 1 for the current number using the offset.
    }

    return ans; // Return the array containing the count of bits set to 1 for each number from 0 to n.
  }
}
