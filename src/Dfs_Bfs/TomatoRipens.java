package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7576
public class TomatoRipens {
    static int[] mX = {1, -1, 0, 0};
    static int[] mY = {0, 0, 1, -1};
    static int n, m;
    static int[][] map;
    static boolean[][] vistied;
    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        vistied = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
                if(map[i][j] == 1){
                    que.offer(new int[]{i, j});
                }
            }
        }

        while (!que.isEmpty()){
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];

            vistied[x][y] = true;

            for(int i = 0; i < 4; i++){
                int nX = x + mX[i];
                int nY = y + mY[i];

                if(nX >= 0 && nX < n && nY >= 0 && nY < m){
                    if(map[nX][nY] == 0 && !vistied[nX][nY]){
                        map[nX][nY] = map[x][y] + 1;
                        que.offer(new int[]{nX, nY});
                    }
                }
            }
        }

        int result = 0;
        boolean noResult = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    noResult = true;
                    break;
                }
                result = Math.max(result, map[i][j]);
            }
            if(noResult){
                break;
            }
        }

        System.out.println(noResult?-1:result-1);
    }
}
