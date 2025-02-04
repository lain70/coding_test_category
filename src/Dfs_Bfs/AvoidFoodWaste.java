package Dfs_Bfs;

import java.io.*;
import java.util.StringTokenizer;

public class AvoidFoodWaste {
    static int[] mX = {1, -1, 0, 0};
    static int[] mY = {0, 0, -1, 1};
    static int n, m, k;
    static int result = 0;
    static int cnt = 0;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        map = new boolean[n + 1][m + 1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            map[x][y] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=m; j++){
                if(map[i][j] == true){
                    dfs(i, j);
                    result = Math.max(result, cnt);
                    cnt = 0;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static boolean dfs(int x, int y){
        if(x < 1 || x>n || y < 1 || y > m){
            return false;
        }
        if(map[x][y]){
            map[x][y] = false;
            cnt++;
            for(int i = 0; i < 4; i++){
                dfs(x+mX[i],y+mY[i]);
            }
            return true;
        }else{
            return false;
        }
    }
}
/*
3 4 5
3 2
2 2
3 1
2 3
1 1
 */