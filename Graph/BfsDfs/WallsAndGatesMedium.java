package BfsDfs;

import java.util.*;

public class WallsAndGatesMedium {

	public int[][] wallsAndGates(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> q = new LinkedList<>();

		int INF = 2147483647;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 ) {
					q.offer(new int[]{i , j});
				}
			}
		}
		int[][] dir = new int[][]{
						{0,1}  ,{0,-1} , {1,0} , {-1, 0}
		};
		while(!q.isEmpty()){
			int[] cell = q.poll();
			int i = cell[0];
			int j = cell[1];

			for(int[] d : dir){
				int newi = i + d[0];
				int newj = j + d[1];

				if(newi < 0 || newj < 0 || newi >= m || newj >= n || grid[newi][newj] != INF){
					continue;
				}

				grid[newi][newj] = 1 + grid[i][j];
				q.offer(new int[]{newi , newj});
			}
		}

		return grid;
	}

	public static void main(String[] args) {

		WallsAndGatesMedium solution = new WallsAndGatesMedium();
		int INF = 2147483647;
		int[][] rooms = {
						{INF, -1, 0, INF},
						{INF, INF, INF, -1},
						{INF, -1, INF, -1},
						{0, -1, INF, INF}
		};

		solution.wallsAndGates(rooms);

		for (int[] row : rooms) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}

