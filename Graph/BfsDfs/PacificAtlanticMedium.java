package BfsDfs;
import java.util.*;

public class PacificAtlanticMedium {

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;

		boolean[][] isPac = new boolean[m][n];
		boolean[][] isAtl = new boolean[m][n];
		Queue<int[]> pac = new LinkedList<>();
		Queue<int[]> atl = new LinkedList<>();

		for(int i = 0 ; i < m ; i++){
			isPac[i][0] = true;
			isAtl[i][n-1] = true;
			pac.offer(new int[]{i , 0});
			atl.offer(new int[]{i , n-1});
		}

		for(int j = 0 ; j < n ; j++){
			isPac[0][j] = true;
			isAtl[m-1][j] = true;
			pac.offer(new int[]{0 , j});
			atl.offer(new int[]{m-1 , j});
		}

		bfs(isPac , pac , heights);
		bfs(isAtl , atl , heights);

		List<List<Integer>> res = new ArrayList<>();
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(isPac[i][j] && isAtl[i][j]){
					res.add(List.of(i , j));
				}
			}
		}

		return res;
	}


	private void bfs(boolean[][] reachable , Queue<int[]> q , int[][] heights){
		int[][] directions = new int[][]{
						{0,1} , {0,-1} , {1,0} , {-1, 0}
		};
		int m = heights.length;
		int n = heights[0].length;
		while(!q.isEmpty()){
			int[] cell = q.poll();
			int i = cell[0];
			int j = cell[1];

			for(int[] dir : directions){
				int newi = i + dir[0];
				int newj = j + dir[1];

				if(newi >= 0 && newj >= 0 && newi < m && newj < n && !reachable[newi][newj] &&
								heights[newi][newj] >= heights[i][j]){
					reachable[newi][newj] = true;
					q.offer(new int[]{newi , newj});
				}
			}
		}
	}

	public static void main(String[] args) {
		PacificAtlanticMedium obj = new PacificAtlanticMedium();
		System.out.println(obj.pacificAtlantic(new int[][]{
						{1,2,2,3,5},
						{3,2,3,4,4},
						{2,4,5,3,1},
						{6,7,1,4,5},
						{5,1,1,2,4}
		}));
	}
}
