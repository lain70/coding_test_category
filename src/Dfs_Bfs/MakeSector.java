package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MakeSector {
	public static int[] mX = {1,-1,0,0};
	public static int[] mY = {0,0,-1,1};
	public static boolean[][] visited;
	public static int cnt = 0;
	
	
	public static void bfs(int[][] section, int nowX, int nowY) {
		visited[nowX][nowY] = true;
		for(int i = 0; i < 4; i++) {
			int nextX = nowX + mX[i];
			int nextY = nowY + mY[i];
			if((nextX > -1 && nextX < section.length) && (nextY > -1 && nextY < section.length) && !visited[nextX][nextY]) {
				if(section[nextX][nextY] == 1) {
					cnt++;
					bfs(section, nextX, nextY);	
				}
					
			}
			
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		
		int[][] section = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			section[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		visited = new boolean[n][n];
		for(boolean[] b : visited) {
			Arrays.fill(b, false);
		}
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(!visited[i][j] && section[i][j] != 0) {
					cnt = 1;
					bfs(section, i, j);
					resultList.add(cnt);
				}
			}
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.size());
		if(resultList.size() > 0) {
			for(int a : resultList) {
				System.out.println(a);
			}	
		}
		
	}
	

}
