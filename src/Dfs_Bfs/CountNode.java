package Dfs_Bfs;

import java.util.Scanner;

public class CountNode {
	
	public static int[][] graph;
	public static int n;
	public static int m;
	public static boolean[] visited;
	
	public static void dfs(int idx) {
		if(visited[idx] == true) {
			return;
		}else {
			visited[idx] = true;
			for(int i = 1; i <= n; i++) {
				if(graph[idx][i] == 1) {
					dfs(i);
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		
		n = Integer.valueOf(input[0]);
		m = Integer.valueOf(input[1]);
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			String[] input2 = sc.nextLine().split(" ");
			
			int u = Integer.valueOf(input2[0]);
			int v = Integer.valueOf(input2[1]);
			
			graph[u][v] = graph[v][u] = 1; 
		}
		
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			if(visited[i] == false) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
