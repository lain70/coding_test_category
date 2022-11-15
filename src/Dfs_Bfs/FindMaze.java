package Dfs_Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindMaze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");

		int n = Integer.valueOf(input[0]);
		int m = Integer.valueOf(input[1]);

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		boolean[][] visited = new boolean[n][m];
		for (boolean[] b : visited) {
			Arrays.fill(b, false);
		}

		int[] mX = { 1, -1, 0, 0 };
		int[] mY = { 0, 0, -1, 1 };

		Queue<int[]> que = new LinkedList<int[]>();

		visited[0][0] = true;
		int[] start = new int[] { 0, 0 };
		que.offer(start);

		while (!que.isEmpty()) {
			int[] now = que.poll();

			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = x + mX[i];
				int nextY = y + mY[i];

				if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m)) {
					if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
						visited[nextX][nextY] = true;
						map[nextX][nextY] = map[x][y] + 1;
						que.offer(new int[] { nextX, nextY });
					}
				}
			}
		}

		System.out.println(map[n - 1][m - 1]);

	}
}
