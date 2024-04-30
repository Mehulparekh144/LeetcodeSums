package BfsDfs;

import java.util.*;

public class CycleInUndirectedGraph {

  boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, int parent) {
    visited[node] = true;

    for (int child : adj.get(node)) {
      if (!visited[child]) {
        if (dfs(child, adj, visited, node)) return true;
      } else if (child != parent) return true;
    }

    return false;

  }

  boolean detectCycle(int V, List<List<Integer>> adj) {
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(i, adj, visited, -1)) {
          return true;
        }
      }
    }

    return false;
  }

  //BFS
  boolean detectCycleBFS(int V, List<List<Integer>> adj) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[V];
    int[] parents = new int[V];
    Arrays.fill(parents, -1);

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        q.offer(i);
        visited[i] = true;

        while (!q.isEmpty()) {
          int node = q.poll();

          for (int child : adj.get(node)) {
            if (visited[child] && parents[node] != child) {
              return true;
            }

            if (!visited[child]) {
              visited[child] = true;
              q.offer(child);
              parents[child] = node;
            }
          }
        }
      }
    }

    return false;
  }
}
