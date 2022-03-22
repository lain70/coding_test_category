package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//น้มุ4963
public class FindLand {
	public static void dfs(int[][] map, int a, int b) {
		int[] x = {-1,-1,-1,0,0,1,1,1};
		int[] y = {-1,0,1,-1,1,-1,0,1};
		map[a][b] = 0;
		
		for(int i = 0; i < 8; i++) {
			if((0 <= a + x[i] && a + x[i] < map.length ) && (0 <= b + y[i] && b + y[i] < map[0].length )) {
				if(map[a + x[i]][b + y[i]] == 1) {
					dfs(map, a + x[i], b + y[i]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> resultList = new ArrayList<>();
		while(true) {
			int[] now = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(now[0] == 0 && now[1] == 0) {
				break;
			}
			
			int w = now[0];
			int h = now[1];
			
			int[][] map = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			int answer = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						dfs(map, i, j);
						answer++;
					}
				}
			}
			resultList.add(answer);
		}
		for(int r : resultList) {
			System.out.println(r);
		}
	}
}
