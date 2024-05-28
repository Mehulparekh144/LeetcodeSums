package Heap;
import java.util.*;
public class TaskSchedulerMedium {
  public int leastInterval(char[] tasks, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    int[] count = new int[26];
    for (char c : tasks) {
      count[c - 'A']++;
    }

    for (int i = 0; i < 26; i++) {
      if (count[i] > 0)
        pq.offer(count[i]);
    }

    int time = 0;

    while (!pq.isEmpty()) {

      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < n + 1; i++) {

        if (!pq.isEmpty()) {
          int freq = pq.poll();
          temp.addLast(--freq);
        }
      }

      for (int freq : temp) {
        if (freq > 0) {
          pq.offer(freq);
        }
      }

      if (pq.isEmpty()) {
        time += temp.size();
      } else {
        time += n + 1;
      }
    }

    return time;
  }
}
