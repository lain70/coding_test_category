package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class RobotCleaner {
	public static int turnLeft(int direction) {
		if (direction == 0) {
			return 3;
		} else {
			return direction - 1;
		}
	}

	public static void main(String[] args) {
		// ºÏ:0, µ¿:1, ³²:2, ¼­:3
		int[] moveX = { -1, 0, 1, 0 };
		int[] moveY = { 0, 1, 0, -1 };
		Scanner sc = new Scanner(System.in);
		String[] info = sc.nextLine().split(" ");
		int n = Integer.valueOf(info[0]);
		int m = Integer.valueOf(info[1]);

		String[] robotPlace = sc.nextLine().split(" ");
		int x = Integer.valueOf(robotPlace[0]);
		int y = Integer.valueOf(robotPlace[1]);
		int direction = Integer.valueOf(robotPlace[2]);

		int[][] map = new int[n][m];

		for (int i = 0; i < map.length; i++) {
			map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		boolean[][] vistied = new boolean[n][m];
		for (boolean[] v : vistied) {
			Arrays.fill(v, false);
		}
		vistied[x][y] = true;
		int answer = 1;
		int turnCnt = 0;
		while (true) {
			direction = turnLeft(direction);

			int nx = x + moveX[direction];
			int ny = y + moveY[direction];

			if ((nx >= 0 && n > nx) && (ny >= 0 && m > ny) && (map[nx][ny] == 0 && !vistied[nx][ny])) {
				vistied[nx][ny] = true;
				x = nx;
				y = ny;
				answer++;
				turnCnt = 0;
				continue;
			} else {
				turnCnt++;
			}

			if (turnCnt == 4) {
				nx = n - moveX[direction];
				ny = y - moveY[direction];
				if ((nx >= 0 && n > nx) && (ny >= 0 && m > ny) && (map[nx][ny] == 0)) {
					x = nx;
					y = ny;
					turnCnt = 0;
				} else {
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
