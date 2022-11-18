package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//백준 2638
public class MeltingCheese {
    public static void main(String[] args) throws IOException {
        int[] mX = new int[]{1,-1,0,0};
        int[] mY = new int[]{0,0,-1,1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = size[0];
        int m = size[1];
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        map[0][0] = 3;

        int result = 0;
        int cheeseCnt = Integer.MAX_VALUE;
        while(cheeseCnt != 0){
            cheeseCnt = 0;
            result += 1;

            visited = new boolean[n][m];
            visited[0][0] = true;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{0,0});
            while(!que.isEmpty()){
                int[] temp = que.poll();
                int x = temp[0];
                int y = temp[1];
                for(int i = 0; i < 4; i++){
                    int nX = x + mX[i];
                    int nY = y + mY[i];

                    if(nX < 0 || nX >= n || nY < 0 || nY >= m){
                        continue;
                    }
                    if(map[nX][nY] == 0){
                        map[nX][nY] = 3;
                        visited[nX][nY] = true;
                        que.offer(new int[]{nX, nY});
                        continue;
                    }
                    if(map[nX][nY] == 3 && visited[nX][nY] != true){
                        visited[nX][nY] = true;
                        que.offer(new int[]{nX, nY});
                        continue;
                    }
                    if(map[nX][nY] == 1 || map[nX][nY] == 2){
                        map[nX][nY] += 1;
                        visited[nX][nY] = true;
                    }

                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j< m; j++){
                    if(map[i][j] == 1){
                        cheeseCnt +=1;
                    }else if(map[i][j] == 2){
                        cheeseCnt +=1;
                        map[i][j] = 1;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
