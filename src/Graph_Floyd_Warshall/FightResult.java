package Graph_Floyd_Warshall;

import java.util.Arrays;
import java.util.Scanner;

public class FightResult {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = info[0];
		int m = info[1];
		
		int maxFight = 10001;
		
		//1부터 시작이기 때문에
		int[][] fight = new int[n+1][n+1];
		for(int[] f : fight){
			Arrays.fill(f, maxFight);
		}
		
		for(int i = 0; i < m; i++){
			int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			fight[input[0]][input[1]] = 1;
		}
		
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j < n + 1; j++){
				System.out.print(fight[i][j] + " ");
			}
			System.out.println("");
		}
			
		
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j < n + 1; j++){
				for(int k = 1; k < n + 1; k++){
					if(fight[j][k] > fight[j][i] + fight[i][k]){
						fight[j][k] = fight[j][i] + fight[i][k];
					}
				}
			}
		}
		System.out.println("");
		
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j < n + 1; j++){
				System.out.print(fight[i][j] + " ");
			}
			System.out.println("");
		}
		
		int answer = 0;
		for(int i = 0; i < n + 1; i++){
			int cnt = 0;
			for(int j = 0; j < n + 1; j++){
				if(fight[i][j] < maxFight || fight[j][i] < maxFight){
					cnt++;
				}
			}
			
			if(cnt == n - 1){
				answer++;
			}
		}		
		
		System.out.println(answer);
	}
}
