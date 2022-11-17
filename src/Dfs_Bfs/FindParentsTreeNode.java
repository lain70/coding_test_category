/**
 * 백준 11725 부모 트리 찾기
 */
package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindParentsTreeNode {
	
	public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	public static int[] parents;
	public static int n;
	
	public static void dfs(int idx, int p) {
		if(parents[idx] == 0) {
			parents[idx] = p;
			
			for(int i = 0; i < tree.get(idx).size(); i++) {
				dfs(tree.get(idx).get(i), idx);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = Integer.valueOf(sc.nextLine());
		
		for(int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		parents = new int[n+1];
		
		Arrays.fill(parents, 0);
		
		for(int i = 0; i < n - 1; i++) {
			String[] input = sc.nextLine().split(" ");
			int a = Integer.valueOf(input[0]);
			int b = Integer.valueOf(input[1]);
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		dfs(1,1);
		
		
		for(int i = 2; i < n + 1; i++) {
			System.out.println(parents[i]);
		}
		
	}
}
