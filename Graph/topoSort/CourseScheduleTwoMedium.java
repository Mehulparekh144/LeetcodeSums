package topoSort;
import java.util.*;

public class CourseScheduleTwoMedium {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0 ; i < numCourses ; i++){
        adj.add(new ArrayList<>());
      }

      int[] indegree = new int[numCourses];
      for(int[] preq : prerequisites){
        adj.get(preq[1]).add(preq[0]);
        indegree[preq[0]]++;
      }

      Queue<Integer> q = new LinkedList<>();

      for(int i = 0 ; i < numCourses ; i++){
        if(indegree[i] == 0){
          q.offer(i);
        }
      }

      List<Integer> order = new ArrayList<>();
      while(!q.isEmpty()){
        int course = q.poll();
        order.add(course);

        for(int child : adj.get(course)){
          indegree[child]--;
          if(indegree[child] == 0){
            q.offer(child);
          }
        }
      }

      if(order.size() != numCourses) return new int[0];

      int[] res = new int[numCourses];
      for (int i = 0; i < order.size() ; i++){
        res[i] = order.get(i);
      }

      return res;
    }



  public static void main(String[] args) {
    CourseScheduleTwoMedium obj = new CourseScheduleTwoMedium();
    System.out.println(Arrays.toString(obj.findOrder(4, new int[][]{
            {1, 0}, {2, 0}, {3, 1}, {3, 2}
    })));
    System.out.println(Arrays.toString(obj.findOrder(2, new int[][]{
            {0,1}
    })));
  }
}
