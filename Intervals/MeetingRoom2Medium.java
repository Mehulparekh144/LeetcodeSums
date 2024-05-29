import java.util.*;

public class MeetingRoom2Medium {

    public int noOfDays(int[][] meetings) {
        int[] start = new int[meetings.length];
        int[] end = new int[meetings.length];

        for (int i = 0; i < meetings.length; i++) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int count = 0;
        int res = 0;

        while (i < meetings.length) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                j++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRoom2Medium obj = new MeetingRoom2Medium();
        
        int[][][] testCases = {
            {{1, 4}, {2, 5}, {3, 6}}, // 3
            {{7, 10}, {2, 4}}, // 1
            {{6, 7}, {2, 4}, {8, 12}}, // 1
            {{1, 10}, {2, 7}, {3, 6}, {4, 5}}, // 4
            {{1, 3}, {3, 5}, {4, 6}, {5, 7}}, // 2
            {{1, 2}, {1, 2}, {1, 2}}, // 3
            {{1, 10}, {10, 20}, {20, 30}}, // 1
            {{1, 4}, {4, 8}, {8, 12}}, // 1
            {{1, 5}, {2, 6}, {3, 7}, {4, 8}}, // 4
            {{5, 8}, {6, 9}, {7, 10}, {8, 11}} // 3
        };

        int[] expectedResults = {3, 1, 1, 4, 2, 3, 1, 1, 4, 3};

        for (int i = 0; i < testCases.length; i++) {
            int result = obj.noOfDays(testCases[i]);
            if (result == expectedResults[i]) {
                System.out.println("\u001B[32mTest Case " + (i + 1) + " Passed\u001B[0m");
            } else {
                System.out.println("\u001B[31mTest Case " + (i + 1) + " Failed\u001B[0m");
            }
        }
    }
}
