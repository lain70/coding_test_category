package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPicture {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int[] mx = {1,-1,0,0};
    static int[] my = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean hasPicture = false;

        visited = new boolean[n][m];
        map = new int[n][m];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreElements()){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) hasPicture = true;
                j++;
            }
        }

        StringBuilder result = new StringBuilder();
        if(!hasPicture){
            result.append("0\n");
            result.append("0");
            System.out.println(result);
            return;
        }

        int cnt = 0;
        int maxSize = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && visited[i][j] != true){
                    int sum = 1;
                    int nowSum = dfs(i, j, sum);
                    maxSize = Math.max(maxSize, nowSum);

                    cnt += 1;
                }
            }
        }
        result.append(cnt+"\n");
        result.append(maxSize);
        System.out.println(result);
    }
    static int dfs(int x, int y, int sum){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + mx[i];
            int ny = y + my[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                continue;
            }

            if(map[nx][ny] == 1 && visited[nx][ny] != true){
                sum = dfs(nx, ny, sum + 1);
            }
        }

        return sum;
    }
}
