package Graph_Disjoint;

import java.util.Arrays;
import java.util.Scanner;

public class PossableTrip {
	public static int findParents(int[] parents, int x) {
		if(parents[x] == x) return x;
		else return parents[x] = findParents(parents, parents[x]);
	}
	
	public static void unionParents(int[] parents, int a, int b) {
		a = findParents(parents, a);
		b = findParents(parents, b);
		
		if(a < b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		int m = Integer.valueOf(sc.nextLine());
		
		int[] parents = new int[n];
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		int[][] node = new int[n][n];
		for(int i = 0; i < n; i++) {
			node[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();			
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(node[i][j] == 1) {
					if(findParents(parents, i) != findParents(parents, j)) {
						unionParents(parents, i, j);
					}
				}
			}
		}
		
		int[] tripNode = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		boolean result = true;
		for(int i = 0; i < tripNode.length - 1; i++) {
			if(parents[tripNode[i]-1] != parents[tripNode[i+1]-1]) {
				result = false;
				break;
			}
		}
		
		String answer = "";
		answer = (result)?"YES":"NO";
		System.out.println(answer);
	}
}
