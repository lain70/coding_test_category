package Graph_Floyd_Warshall;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpaceFinder {
    private static int N;
    private static int K;

    private static boolean[] visited;
    private static int[][] map;

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        visited = new boolean[N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for (int t = 0; t < N; t++) {
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (a != b) {
                        if (map[a][b] > map[a][t] + map[t][b]) {
                            map[a][b] = map[a][t] + map[t][b];
                        }
                    }
                }
            }
        }

        visited[K] = true; //시작점을 체크하고 진입한다.
        DFS(1, K, 0); //주의: depth가 1부터 시작

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, int start, int dist) {
        if(depth == N) {
            min = Math.min(dist, min);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(i == start) { continue; }

            if(!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, i, dist + map[start][i]);
                visited[i] = false;
            }
        }
    }

}
