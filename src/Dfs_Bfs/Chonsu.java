package Dfs_Bfs;

import java.util.Arrays;
import java.util.Scanner;

public class Chonsu {
	
	public static int result = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		String[] input = sc.nextLine().split(" ");
		int x = Integer.valueOf(input[0]);
		int y = Integer.valueOf(input[1]);
		
		int m = Integer.valueOf(sc.nextLine());
		
		int[][] family = new int[n+1][n+1];
		
		for(int[] f : family) {
			Arrays.fill(f, 0);
		}
		
		for(int i = 0; i < m; i++) {
			String[] rel = sc.nextLine().split(" ");
			family[Integer.valueOf(rel[0])][Integer.valueOf(rel[1])] = 1;
			family[Integer.valueOf(rel[1])][Integer.valueOf(rel[0])] = 1;
		}
		
		dfs(family, x, y, 0);
		
		System.out.println(result);
	}
	
	public static void dfs(int[][] family, int start, int end, int cnt) {
		
		if(start == end) {
			result = cnt;
			return;
		}
		
		for(int i = 1; i < family[start].length; i++) {
			if(family[start][i] == 1) {
				family[start][i] = 0;
				dfs(family, i, end, cnt+1);
			}
		}
	}
}
