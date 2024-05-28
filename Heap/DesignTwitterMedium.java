package Heap;
import java.util.*;

public class DesignTwitterMedium {
 
  private Map<Integer, Set<Integer>> userMap;
  private Map<Integer, Set<int[]>> tweetMap;
  private int count;

  public DesignTwitterMedium() {
    userMap = new HashMap<>();
    tweetMap = new HashMap<>();
    count = 0;
  }

  public void postTweet(int userId, int tweetId) {
    if (!tweetMap.containsKey(userId)) {
      tweetMap.put(userId, new HashSet<>());
    }
    tweetMap.get(userId).add(new int[] { count, tweetId });
    count++;
  }

  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    if (tweetMap.containsKey(userId)) {
      for (int[] pair : tweetMap.get(userId)) {
        pq.offer(pair);
      }
    }
    if (userMap.containsKey(userId) && !userMap.get(userId).isEmpty()) {
      for (int followeeId : userMap.get(userId)) {
        if (tweetMap.containsKey(followeeId)) {
          for (int[] pair : tweetMap.get(followeeId)) {
            pq.offer(pair);
          }
        }
      }
    }

    List<Integer> tweets = new ArrayList<>();
    int k = 0;
    while (!pq.isEmpty() && k < 10) {
      tweets.add(pq.poll()[1]);
      k++;
    }

    return tweets;
  }

  public void follow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId)) {
      userMap.put(followerId, new HashSet<>());
    }
    userMap.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId))
      return;
    userMap.get(followerId).remove(followeeId);
  }


  public static void main(String[] args) {
//     "Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
// [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
    DesignTwitterMedium obj = new DesignTwitterMedium();
    obj.postTweet(1, 5);
    System.out.println(obj.getNewsFeed(1));
    obj.follow(1,2);
    obj.postTweet(2, 6);
    System.out.println(obj.getNewsFeed(1));
    obj.unfollow(1, 2);
    System.out.println(obj.getNewsFeed(1));

  }
}
