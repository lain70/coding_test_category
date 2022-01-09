package Implementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class MoveSnake {
	
	public static void main(String[] args) {		
		//RIGHT, DOWN, LEFT, UP, 
		int[] moveX = {0, 1, 0, -1};
		int[] moveY = {1, 0, -1, 0};
		
		int direction = 0; //RIGHT(0), DOWN(1), LEFT(2), UP(3)
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); sc.nextLine();
		int k = sc.nextInt(); sc.nextLine();
		
		int[][] map = new int[n+1][n+1];
		for(int[] m : map) {
			Arrays.fill(m, 0);	
		}
		

		for(int i = 0 ; i < k; i++) {
			int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer:: parseInt).toArray();
			int x = input[0]; 
			int y = input[1];
			map[x][y] = 1;
		}
		
		int l = sc.nextInt(); sc.nextLine();
		
		String[][] move = new String[l][2];
		for(int j = 0; j < l; j++) {
			String[] input = sc.nextLine().split(" ");
			move[j][0] = input[0];
			move[j][1] = input[1];
		}
		
		int nowX = 1;
		int nowY = 1;
		
		 Queue<Position> q = new LinkedList<>();
	        q.offer(new Position(nowX, nowY));
		
		int time = 0;
		
		map[1][1] = 2; //처음 시작 위치에 뱀표시
		int j = 0;
		while (true) {
			System.out.println("time : " + time + " / nowX : " + nowX + " / nowY : " + nowY + " / j : " + j);
			time++;
			int tempX = nowX + moveX[direction];
			int tempY = nowY + moveY[direction];
			
			if ((tempX < 1 || tempX > n) || (tempY < 1 || tempY > n) || (map[tempX][tempY] == 2)) {
				break;
			}

			if (map[tempX][tempY] == 0) {
				Position prev = q.poll();
				map[prev.getX()][prev.getY()] = 0;
			}else if(map[tempX][tempY] == 0) {
				
			}

			nowX = tempX;
			nowY = tempY;

			q.offer(new Position(nowX, nowY));
			map[nowX][nowY] = 2;
			
			if (j < move.length && Integer.valueOf(move[j][0]) == time) {
				// 방향 변경
				if ("L".equals(move[j][1])) {
					direction = (direction == 0)? 3 : direction - 1;
				} else {
					direction = (direction == 3)? 0 : direction + 1;
				}
				j++;
			}		

		}
		
		System.out.println(time);
	}
	
}
