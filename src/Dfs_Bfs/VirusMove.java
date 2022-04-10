package Dfs_Bfs;

import java.util.Arrays;
import java.util.Scanner;

//백준2606
public class VirusMove {
	public static int cnt;
	public static void dfs(int[][] node, int now, boolean[] visited) {	
		cnt++;
		visited[now] = true;
		
		for(int i = 0; i < node[now].length; i++) {
			if(!visited[i] && node[now][i] == 1) {
				
				dfs(node, i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		int v = Integer.valueOf(sc.nextLine());
		
		int[][] node = new int[n+1][n+1];
		for(int i = 0; i < v; i++) {
			int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			node[input[0]][input[1]] = 1;
			node[input[1]][input[0]] = 1;
		}
		
		boolean[] visited = new boolean[n+1];
		Arrays.fill(visited, false);
		
		dfs(node, 1, visited);		
		System.out.println(cnt-1);
		
	}
}
