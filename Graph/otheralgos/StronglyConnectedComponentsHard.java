package otheralgos;
import java.util.*;

public class StronglyConnectedComponentsHard {
	private void dfs(int node , ArrayList<ArrayList<Integer>> adj , Stack<Integer> st , boolean[] vis){
		vis[node] = true;

		for(int child : adj.get(node)){
			if(!vis[child]){
				dfs(child , adj , st , vis);
			}
		}

		st.push(node);
	}

	private void dfs2(int node , ArrayList<ArrayList<Integer>> reversed , boolean[] vis){
		vis[node] = true;
		for(int child : reversed.get(node)){
			if(!vis[child]){
				dfs2(child , reversed , vis);
			}
		}
	}
	public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
	{
		Stack<Integer> st = new Stack<>();
		boolean[] vis = new boolean[V];
		// Perform dfs 1 on the graph
		for(int i = 0 ; i < V ; i++){
			if(!vis[i]){
				dfs(i , adj , st , vis);
			}
		}

		//Reverse the graph
		ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();
		for(int i = 0 ; i < V ; i++){
			reversed.add(new ArrayList<>());
		}

		for (int i = 0; i < V; i++) {
			List<Integer> it = adj.get(i);
			for(int child : it){
				reversed.get(child).add(i);
			}
		}
		Arrays.fill(vis , false);
		int count = 0;
		// Perform dfs again
		while(!st.isEmpty()){
			int node = st.pop();
			if(!vis[node]){
				dfs2(node , reversed , vis );
				count++;
			}

		}


		return count;
	}

	public static void main(String[] args) {
		StronglyConnectedComponentsHard obj = new StronglyConnectedComponentsHard();
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<>(List.of(1)));
		a.add(new ArrayList<>(List.of(2)));
		a.add(new ArrayList<>(List.of(0 , 3)));
		a.add(new ArrayList<>(List.of(4)));
		a.add(new ArrayList<>(List.of(5,7)));
		a.add(new ArrayList<>(List.of(6)));
		a.add(new ArrayList<>(List.of(4,7)));
		a.add(new ArrayList<>());
		System.out.println(obj.kosaraju(8 , a));
	}
}
