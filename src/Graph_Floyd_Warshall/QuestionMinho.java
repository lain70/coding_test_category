package Graph_Floyd_Warshall;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionMinho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		int[][] map = new int[n][n];
		boolean[][] origin = new boolean[n][n]; 
		
		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(origin[i], false);
		}
		
		for(int k = 0; k < n; k++) {
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					if(a == k || k == b|| b == a) {
						continue;
					}
					
					if(map[a][b] > map[a][k] + map[k][b]) {
						System.out.println(a + " / " + k + " / " + b + map[a][b] + " / " +  map[a][k] + " / " + map[k][b]);
						System.out.println(-1);
						return;
					}
					
					if(map[a][b] == map[a][k] + map[k][b]) {
						origin[a][b] = true;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				
				if(!origin[i][j]) {
					answer += map[i][j];
				}
			}
		}
		
		System.out.println(answer /2 );
	}
}
