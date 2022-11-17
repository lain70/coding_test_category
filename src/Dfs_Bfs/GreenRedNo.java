package Dfs_Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 10026
public class GreenRedNo {
	public static char[][] map;
	public static boolean[][] visited;
	
	public static boolean dfs1(int x, int y, int n, char color) {
		if((x < 0 || x >= n) || (y < 0 || y >= n)) {
			return false;
		}
		
		if(!visited[x][y] && map[x][y] == color) {
			visited[x][y] = true;
			dfs1(x+1, y, n, color);
			dfs1(x-1, y, n, color);
			dfs1(x, y+1, n, color);
			dfs1(x, y-1, n, color);
			return true;
		}
		
		return false;		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		map = new char[n][n];		
		
		for(int i = 0; i <n; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		
		visited = new boolean[n][n];
		for(boolean[] v : visited) {
			Arrays.fill(v, false);
		}
		
		int cnt1 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					char color = map[i][j];
					
					if(dfs1(i, j, n, color)) {
						cnt1++;
					}
				}
			}			
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
					
			}			
		}
		
		visited = new boolean[n][n];
		
		int cnt2 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					char color = map[i][j];
					
					if(dfs1(i, j, n, color)) {
						cnt2++;
					}
				}
			}			
		}
		
		System.out.println(cnt1 + " " + cnt2);
		
	}
}
