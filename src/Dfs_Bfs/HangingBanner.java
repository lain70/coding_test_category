package Dfs_Bfs;

import java.io.*;
import java.util.StringTokenizer;

//14716 백준
public class HangingBanner {
    static int[] mX = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] mY = { -1, 0, 1, -1, 0, 1, -1, 1 };
    static int m, n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        map[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nX = x + mX[i], nY = y + mY[i];
            if (nX >= 0 && nY >= 0 && nX < m && nY < n) {
                if (map[nX][nY] == 1) {
                    dfs(nX, nY);
                }
            }
        }
    }
}
/*
8 19
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 0
0 0 1 0 1 0 0 1 1 0 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 1 1 1 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 1 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */