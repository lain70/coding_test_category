package Dfs_Bfs;

import java.io.*;
import java.util.StringTokenizer;

//백준 21736
public class FindFriend {
    static int[] mX = {1,-1,0,0};
    static int[] mY = {0,0,-1,1};
    static char[][] map;
    static boolean[][] vistied;
    static int cnt = 0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        map = new char[n][m];
        vistied = new boolean[n][m];

        int iX = 0;
        int iY = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char input = str.charAt(j);
                map[i][j] = input;
                if ('I' == input) {
                    iX = i;
                    iY = j;
                }
            }
        }

        bfs(iX, iY);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt == 0 ? "TT" : String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y){
        vistied[x][y] = true;
        if('P' == map[x][y]){
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + mX[i];
            int nY = y + mY[i];
            if (nX >= 0 && nY >= 0 && nX < n && nY < m) {
                if(!vistied[nX][nY] && 'X' != map[nX][nY]){
                    bfs(nX, nY);
                }
            }
        }
    }
}
