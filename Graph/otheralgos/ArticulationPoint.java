package otheralgos;

import java.util.*;

public class ArticulationPoint {
	private int timer = 1;
	public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
	{
		ArrayList<Integer> res = new ArrayList<>();
		int[] tin = new int[V];
		int[] low = new int[V];
		boolean[] vis = new boolean[V];
		int[] mark = new int[V];
		for(int i = 0 ; i < V ; i++) {
			dfs(0, -1, mark , tin, low, vis, adj);
		}

		for(int i = 0 ; i < V ; i++){
			if(mark[i] == 1){
				res.add(i);
			}
		}

		if(res.isEmpty()){
			res.add(-1);
		}
		return res;
	}

	private void dfs(int node, int parent ,
									 int[] mark,
									 int[] tin, int[] low, boolean[] vis,
									 ArrayList<ArrayList<Integer>> adj) {
		vis[node] = true;
		tin[node] = low[node] = timer;
		timer++;
		int noOfChildren = 0;

		for(int child : adj.get(node)){
			if(child == parent) continue;
			if(!vis[child]){
				dfs(child , node , mark ,tin , low , vis , adj);
				low[node] = Math.min(low[node] , low[child]);

				if(low[child] >= tin[node] && parent != -1){
					mark[node] = 1;
				}
				noOfChildren++;
			} else{
				low[node] = Math.min(low[node] , tin[child]);
			}
		}

		if(noOfChildren > 1 && parent == -1){
			mark[node] = 1;
		}
	}

	public static void main(String[] args) {
		ArticulationPoint obj = new ArticulationPoint();
		List<List<Integer>> graph = List.of(
						List.of(1), List.of(0, 4),
						List.of(3, 4), List.of(4, 2), List.of(1, 2, 3)
		);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for (List<Integer> list : graph) {
			adjList.add(new ArrayList<>(list));
		}
		System.out.println(obj.articulationPoints(5, adjList));
	}

}
