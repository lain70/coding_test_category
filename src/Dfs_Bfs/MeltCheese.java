package Dfs_Bfs;

import java.io.*;
import java.util.StringTokenizer;

//백준 2636
public class MeltCheese {
    public static int[] mX = {1,-1,0,0};
    public static int[] mY = {0,0,-1,1};
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        map = new int[n][m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
                if(map[i][j] == 1){
                    sum += 1;
                }
            }
        }



        boolean[][] outAir;
        int last = Integer.MAX_VALUE;
        int times = 0;
        while (sum > 0){
            // 치즈 겉면의 공기 체크 (테두리는 반드시 0이기 때문에 겉면 공기는 연결되어 있다.)
            outAir = new boolean[n][m];
            outAir(0, 0, outAir);
            times++;
            int meltCnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        if(checkOutCheese(i, j, times+1, outAir)){
                            map[i][j] = times + 2;
                            meltCnt += 1;
                        }

                    }
                }
            }
            last = meltCnt;
            sum -= meltCnt;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(times));
        bw.newLine();
        bw.write(String.valueOf(last));
        bw.flush();
        bw.close();
    }

    // 공기가 치즈 겉면 공기인지 체크 한다.
    static void outAir(int x, int y, boolean[][] outAir){
        outAir[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = x + mX[i];
            int nY = y + mY[i];

            if(nX >= 0 && nY >= 0 && nX < n && nY < m){
                if((map[nX][nY] == 0 && !outAir[nX][nY]) || (map[nX][nY] > 1 && !outAir[nX][nY])){
                    outAir(nX, nY, outAir);
                }
            }
        }
    }

    static boolean checkOutCheese(int x, int y, int times, boolean[][] outAir){
        for (int i = 0; i < 4; i++) {
            int nX = x + mX[i];
            int nY = y + mY[i];

            if(map[nX][nY] == times || (map[nX][nY] == 0 && outAir[nX][nY])){
                return true;
            }
        }
        return false;
    }

    
}
/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
 */
