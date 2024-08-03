package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 2423
public class TurnOnLitghts {
    static int[] udX = new int[]{1, -1, 0, 0};
    static int[] udY = new int[]{0, 0, -1, 1};
    static int[] crX = new int[]{1, 1, -1, -1};
    static int[] crY = new int[]{1, -1, 1, -1};
    static char[][] map;
    static int[][] visited;
    static int n,m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        int cnt = map[n - 1][m - 1] == '\\' ? 0 : 1;
        cnt += map[0][0] == '\\' ? 0 : 1;
        map[n - 1][m - 1] = '\\';
        bfs();

//        System.out.println(visited[n - 1][n - 1] == Integer.MAX_VALUE ? "NO SOLUTION" : visited[n - 1][n - 1]);
    }

    private static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        pq.offer(new Node(0,0, 0,"\\"));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(now.x == n - 1 && now.y == m - 1) {
                visited[n - 1][m - 1] = now.cnt;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nX = now.x + udX[i], nY = now.y + udY[i];
                if (check(nX, nY)) {
                    if(visited[nX][nY] > visited[now.x][now.y]){
                    }
                }
            }

            for(int i = 0; i < 4; i++) {
                int nX = now.x + udX[i], nY = now.y + udY[i];
                if (check(nX, nY)) {
                    if(visited[nX][nY] < visited[now.x][now.y]){
                    }
                }
            }
        }
    }
    
    static boolean check(int x, int y){
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }
    
    static class Node{
        int x,y, cnt;
        String line;

        public Node(int x, int y, int cnt, String line) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.line = line;
        }
    }
}
