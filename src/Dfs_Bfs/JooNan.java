package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JooNan {
    static int[] mX = {1, -1, 0, 0}, mY = {0, 0, -1, 1};
    static int n, m, x1, y1, x2, y2, cnt;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        x1 = Integer.valueOf(st.nextToken());
        y1 = Integer.valueOf(st.nextToken());
        x2 = Integer.valueOf(st.nextToken());
        y2 = Integer.valueOf(st.nextToken());

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while(true){
            cnt += 1;
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
            visited[x1 - 1][y1 - 1] = true;
            if(bfs()){
                break;
            }
        }
        System.out.println(cnt);
    }

    static boolean bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x1-1, y1-1});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nowX = now[0], nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nX = nowX + mX[i], nY = nowY + mY[i];
                if(nX == x2 - 1 && nY == y2 - 1){
                    return true;
                }
                if (nX >= 0 && nX < n && nY >= 0 && nY < m) {
                    if (!visited[nX][nY]){
                        if(map[nX][nY] == '1'){
                            map[nX][nY] = '0';
                            visited[nX][nY] = true;
                        } else {
                            visited[nX][nY] = true;
                            que.offer(new int[]{nX, nY});
                        }
                    }
                }
            }
        }
        return false;
    }
}
