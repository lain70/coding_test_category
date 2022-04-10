package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BasicDfsBfs {
	
public static void dfs(int[][] node, int now, boolean[] visited, List<Integer> result) {		
		result.add(now);
		visited[now] = true;
		
		for(int i = 1; i < node[now].length; i++) {
			if(!visited[i] && node[now][i] == 1) {
				dfs(node, i, visited, result);
			}
		}
				
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[][] node = new int[info[0] + 1][info[0] + 1];
		
		for(int[] a : node) {
			Arrays.fill(a, 0);
		}
		
		for(int i = 0; i < info[1]; i++) {
			int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			node[input[0]][input[1]] = 1;
			node[input[1]][input[0]] = 1;
		}
		
		List<Integer> dfsResult = new ArrayList<Integer>();
		
		boolean[] visited = new boolean[info[0] + 1];
		Arrays.fill(visited, false);
		
		dfs(node, info[2], visited, dfsResult);
		
		List<Integer> bfsResult = new ArrayList<Integer>();
		
		boolean[] visited2 = new boolean[info[0] + 1];
		Arrays.fill(visited2, false);
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(info[2]);
		visited2[info[2]] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			bfsResult.add(now);
			
			
			for(int i = 1; i < node[now].length; i++) {
				if(!visited2[i] && node[now][i] == 1) {
					visited2[i] = true;
					que.offer(i);
				}
			}
			
		}
		
		for(int k : dfsResult) {
			System.out.print(k + " ");
		}
		
		System.out.println("");
		
		for(int k : bfsResult) {
			System.out.print(k + " ");
		}		
		
	}
}
