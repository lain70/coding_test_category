package Dfs_Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinDistanceBridge {
	public static void main(String[] args) {
		int[] mX = { 1, -1, 0, 0 };
		int[] mY = { 0, 0, -1, 1 };
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine());

		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(visited[i], false);
		}

		int idx = 2;

		// 대륙간 구분을 위해 숫자 변경
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					que.offer(new int[] { i, j });

					while (!que.isEmpty()) {
						int[] now = que.poll();

						int nowX = now[0];
						int nowY = now[1];

						map[nowX][nowY] = idx;
						visited[nowX][nowY] = true;

						for (int k = 0; k < 4; k++) {
							int nextX = nowX + mX[k];
							int nextY = nowY + mY[k];

							if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < n)) {
								if (map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
									que.add(new int[] { nextX, nextY });
								}
							}
						}
					}
					idx++;
				}
			}
		}

		if (idx == 2) {
			System.out.println(0);
			return;
		}

		// 대륙간 가장 짧은 다리 찾기

		int minBridge = Integer.MAX_VALUE;//// 최소 다리
		
		for(boolean[] v : visited) {
			Arrays.fill(v, false);	
		}
		
		boolean[][] check = new boolean[n][n];
		// 대륙간 구분을 위해 숫자 변경
		Queue<int[]> que2 = new LinkedList<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {	//방문한 적 없고 육지인경우
					que.offer(new int[] { i, j, 0 });
					visited[i][j] = true;	// 방문 처리
					
					for(boolean[] c : check) {
						Arrays.fill(c, false);
					}
					
					int nowIdx = map[i][j];	//현재 육지					
					
					while (!que.isEmpty()) {
						int[] now = que.poll();

						int nowX = now[0];
						int nowY = now[1];
						int distance = now[2];

						for (int k = 0; k < 4; k++) {
							int nextX = nowX + mX[k];
							int nextY = nowY + mY[k];

							if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < n)) {								
								if(map[nextX][nextY] == nowIdx) {	//같은 육지이면 패스
									continue;
								}
								
								if (map[nextX][nextY] == 0 && !check[nextX][nextY]) {	//바다이고 방문한적 없는 경우
									check[nowX][nowY] = true;	//방문처리
									que.add(new int[] { nextX, nextY, distance+1 });
									continue;
								}
								
								if(map[nextX][nextY] != 0 && map[nextX][nextY] != nowIdx) {	//다른 육지 인 경우
									if(distance < minBridge) {
										minBridge = distance;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(minBridge);
	}
}
