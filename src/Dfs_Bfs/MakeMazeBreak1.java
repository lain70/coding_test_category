package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2665
public class MakeMazeBreak1 {
    static int[][] map;
    static int[][] dp;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        map = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        bfs();

        System.out.println(dp[n-1][n-1]);
    }

    public static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0], y = now[1];

            for(int i = 0; i < 4; i++){
                int nX = x + dx[i], nY = y + dy[i];
                if(nX >= 0 && nX < map.length && nY >= 0 && nY < map.length){
                    if(dp[nX][nY] > dp[x][y]){
                        if(map[nX][nY] == 1){
                            dp[nX][nY] = dp[x][y];
                        }else {
                            dp[nX][nY] = dp[x][y] + 1;
                        }
                        que.offer(new int[]{nX, nY});
                    }
                }
            }
        }

    }
}
