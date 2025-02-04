package Dfs_Bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// backjoon 1584
// 0,0 -> 500,500 으로 가는 최단거리를 구하는게 목적이 아니다. 목적지까지만 갈 수 있다면 최소생명력 손실을 구하는게 목적이다.
public class PlayGame {
    static int[] mX = {1, -1, 0, 0}, mY = {0, 0, -1, 1};
    static int[][] map = new int[501][501], dp = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        for(int[] d : dp){
            Arrays.fill(d, 250001);
        }
        dp[0][0] = 0;
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());
            marking(x1, x2, y1, y2, 1);
        }
        int m = Integer.valueOf(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());
            marking(x1, x2, y1, y2, -1);
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0], y = now[1];

            for (int i = 0; i < 4; i++) {
                int nX = x + mX[i], nY = y + mY[i];
                if (nX >= 0 && nX < 501 && nY >= 0 && nY < 501) {
                    if (map[nX][nY] != -1) {
                        if(dp[nX][nY] > dp[x][y] + map[nX][nY]){
                            dp[nX][nY] = dp[x][y] + map[nX][nY];
                            que.offer(new int[]{nX, nY});
                        }
                    }
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String result = String.valueOf(dp[500][500] == 250001 ? -1 : dp[500][500]);
        bw.write(result);
        bw.newLine();
        bw.flush();
        bw.close();
    }

    static void marking(int x1, int x2, int y1, int y2, int mark){
        int a1 = Math.min(x1, x2);
        int a2 = Math.max(x1, x2);
        int b1 = Math.min(y1, y2);
        int b2 = Math.max(y1, y2);
        for(int i = a1; i <= a2; i++){
            for(int j = b1; j <= b2; j++){
                map[i][j] = mark;
            }
        }
    }
}
