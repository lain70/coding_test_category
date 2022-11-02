package Dfs_Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MFindMaze {
    public static void main(String[] args) {
        int[] mX = new int[]{1,-1,0,0};
        int[] mY = new int[]{0,0,-1,1};
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());

        int[][] maze = new int[n][m];
        for(int i = 0 ; i < n; i++){
            maze[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});

        while (!que.isEmpty()){
            int[] tempIdx = que.poll();
            int x = tempIdx[0];
            int y = tempIdx[1];

            for(int i = 0 ; i < 4; i++){
                int nX = x + mX[i];
                int nY = y + mY[i];

                if(nX < 0 || nX >= n || nY < 0 || nY >= m){
                    continue;
                }

                if(maze[nX][nY] == 0){
                    continue;
                }

                if(maze[nX][nY] == 1){
                    maze[nX][nY] = maze[x][y] + 1;
                    que.offer(new int[]{nX, nY});
                }
            }
        }
        System.out.println(maze[n-1][m-1]);
    }
}
