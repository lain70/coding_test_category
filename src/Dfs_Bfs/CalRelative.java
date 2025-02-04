package Dfs_Bfs;

import java.io.*;
import java.util.StringTokenizer;

public class CalRelative {
    static int n, target1, target2, result = -1;
    static boolean[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        arr = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        target1 = Integer.valueOf(st.nextToken());
        target2 = Integer.valueOf(st.nextToken());

        int m = Integer.valueOf(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;
        }

        dfs(target1, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static void dfs(int now, int cnt){
        if(now == target2){
            result = cnt;
            return;
        }

        visited[now] = true;
        for(int i = 1; i <= n; i++){
            if(!visited[i] && arr[now][i]){
                dfs(i, cnt+1);
            }
        }
    }
}
