package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1012
public class BaechuWorm {
    static int[] mX = {1, -1, 0, 0};
    static int[] mY = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken()), n = Integer.valueOf(st.nextToken()), k = Integer.valueOf(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                map[Integer.valueOf(st.nextToken())][Integer.valueOf(st.nextToken())] = 1;
            }

            int cnt = 0;
            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){
                    if(map[x][y] == 1 && !visited[x][y]){
                        bfs(x, y);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = x + mX[i];
            int nY = y + mY[i];

            if (nX >= 0 && nX < map.length && nY >= 0 && nY < map[0].length) {
                if(map[nX][nY] == 1 && !visited[nX][nY]){
                    bfs(nX, nY);
                }
            }
        }
    }
}
