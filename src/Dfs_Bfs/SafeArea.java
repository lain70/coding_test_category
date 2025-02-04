package Dfs_Bfs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//backjoon 2468
public class SafeArea {
    static int[] mX = {1, -1, 0, 0}, mY = {0, 0, -1, 1};
    static int[][] map;
    static int n;
    static int peakArea = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int info = Integer.valueOf(st.nextToken());
                map[i][j] = info;
                peakArea = Math.max(peakArea, info);
            }
        }

        int safeArea = 0;
        for(int i = 1; i <= peakArea; i++){
            int cntArea = findSafeArea(i);
            safeArea = Math.max(safeArea, cntArea);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(safeArea));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    static int findSafeArea(int peak){
        int[][] newMap = new int[n][n];
        for(int i = 0; i < n; i++){
            newMap[i] = Arrays.copyOf(map[i],map[i].length);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(newMap[i][j] >= peak){
                    if(dfs(newMap, i, j, peak)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static boolean dfs(int[][] newMap, int a, int b, int peak){
        if (a < 0 || a >= n || b < 0 || b >= n) {
            return false;
        }

        if(newMap[a][b] >= peak){
            newMap[a][b] = -1;

            for(int i = 0; i < 4; i++){
                int nX = a + mX[i];
                int nY = b + mY[i];
                dfs(newMap, nX, nY, peak);
            }
            return true;
        }
        return false;
    }
}
