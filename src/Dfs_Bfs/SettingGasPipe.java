package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 3109
// 1 <= r < 10000 / 5 <= c < 500
public class SettingGasPipe {
    static int r, c, result;
    static int[] mX = new int[]{-1, 0, 1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            if(dfs(i,0)) result++;
        }

        System.out.println(result);

    }

    public static boolean dfs(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + mX[i];
            int ny = y + 1;

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (visited[nx][ny] !=true && map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    if (ny == c - 1) return true;
                    if(dfs(nx, ny)) return true;
                }
            }
        }
        return false;
    }
}
