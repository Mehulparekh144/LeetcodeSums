package otheralgos;
import java.util.*;

public class CriticalConnectionsHard {
	/*
	This is the code to find edges in the graph. It uses Tarjan's Algorithm
	 */
	private int timer = 1;
	private void dfs(int node , int parent , List<List<Integer>> adj , int[] visited , int[] tin , int[] low , List<List<Integer>> bridges){
		visited[node] = 1;
		tin[node] = low[node] = timer;
		timer++;

		for(int child : adj.get(node)){
			if(child == parent) continue;

			if(visited[child] == 0){
				dfs(child , node , adj , visited , tin , low , bridges);

				// After the dfs the child comes back to node. so we get the minimum low time for both of them and assign it to the parent node.
				low[node] = Math.min(low[node] , low[child]);

				// If tin[node] is less than low[child] that means child cannot be reached from the node indicating there is a bridge between them
				if(tin[node] < low[child]){
					bridges.add(List.of(node , child));
				}
			}
			else{
				low[node] = Math.min(low[node] , low[child]);
			}
		}
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0 ; i < n ; i++){
			adj.add(new ArrayList<>());
		}

		for(List<Integer> c : connections){
			int u = c.get(0);
			int v = c.get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		int[] visited = new int[n];
		int[] tin = new int[n];
		int[] low = new int[n];
		List<List<Integer>> bridges = new ArrayList<>();
		dfs(0 , -1 ,adj , visited , tin , low , bridges);
		return bridges;
	}
}
