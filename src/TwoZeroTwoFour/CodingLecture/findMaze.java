package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class findMaze {
    public static int[] nX = {1, -1, 0, 0};
    public static int[] nY = {0, 0, 1, -1};
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        boolean[][] visited = new boolean[n][m];
        for(boolean[] v : visited){
            Arrays.fill(v, false);
        }
        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++){
            maze[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        while (!queue.isEmpty()){
            int[] loc = queue.poll();
            int x = loc[0];
            int y = loc[1];
            for(int i = 0; i < 4; i++){
                int nextX = x + nX[i];
                int nextY = y + nY[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if(maze[nextX][nextY] == 0){
                    continue;
                }
                if (maze[nextX][nextY] == 1) {
                    maze[nextX][nextY] = maze[x][y] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        System.out.println(maze[n - 1][m - 1]);
    }
}
