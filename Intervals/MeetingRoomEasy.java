import java.util.*;
public class MeetingRoomEasy {
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int lastE = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      int s = intervals[i][0];
      int e = intervals[i][1];
      if (s >= lastE) {
        lastE = e;
      } else {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    MeetingRoomEasy obj = new MeetingRoomEasy();

    // Define ANSI color codes
    String ANSI_RESET = "\u001B[0m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RED = "\u001B[31m";

    // Test cases and expected results
    int[][][] testCases = {
        { { 0, 30 }, { 5, 10 }, { 15, 20 } }, // false
        { { 7, 10 }, { 2, 4 } }, // true
        { { 1, 5 }, { 6, 10 }, { 11, 15 } }, // true
        { { 5, 8 }, { 9, 12 }, { 8, 10 } }, // false
        { { 2, 4 }, { 4, 6 }, { 6, 8 } }, // true
        { { 10, 15 }, { 15, 20 }, { 20, 25 } }, // true
        { { 1, 3 }, { 2, 6 }, { 8, 10 } }, // false
        { { 3, 7 }, { 8, 12 }, { 14, 18 } }, // true
        { { 4, 8 }, { 9, 13 }, { 10, 12 } }, // false
        { { 1, 2 }, { 2, 3 }, { 3, 4 } }, // true
        { { 1, 10 }, { 5, 6 } } // false
    };
    boolean[] expectedResults = {
        false, true, true, false, true, true, false, true, false, true, false
    };

    // Run test cases
    for (int i = 0; i < testCases.length; i++) {
      boolean result = obj.canAttendMeetings(testCases[i]);
      if (result == expectedResults[i]) {
        System.out.println(ANSI_GREEN + "Test case " + (i + 1) + " passed." + ANSI_RESET);
      } else {
        System.out.println(ANSI_RED + "Test case " + (i + 1) + " failed." + ANSI_RESET);
      }
    }
  }
}
