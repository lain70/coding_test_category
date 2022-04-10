package Dfs_Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindMinMaze {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input =  sc.nextLine().split(" ");
		int n = Integer.valueOf(input[0]);
		int m = Integer.valueOf(input[1]);
		
		int[][] maze = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			maze[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		int[] mX = {1,-1,0,0};
		int[] mY = {0,0,-1,1};
		
		
		int x = 0;
		int y = 0;
		
		boolean[][] visited = new boolean[n][m];
		
		for(boolean[] b : visited) {
			Arrays.fill(b, false);
		}
		visited[0][0] = true;
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + mX[i];
				int nextY = nowY + mY[i];
				
				if((nextX > -1 && nextX < n) && (nextY > -1 && nextY < m) && !visited[nextX][nextY]) {
					if(maze[nextX][nextY] == 1) {
						que.add(new int[] {nextX, nextY});
						maze[nextX][nextY] = maze[nowX][nowY] + 1;
						visited[nextX][nextY] = true;
					}
				}
			}
		}
		
		System.out.println(maze[n-1][m-1]);
				
	}
}
