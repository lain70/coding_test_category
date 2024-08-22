package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class VotePresi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                graph[i][j] = 251;
            }
            graph[i][i] = 0;
        }
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            if(a == -1 || b == -1){
                break;
            }
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    if(a == k || b == k || a == b){
                        continue;
                    }
                    if(graph[a][b] > graph[a][k] + graph[k][b]) {
                        graph[a][b] = graph[a][k] + graph[k][b];
                    }
                }
            }
        }

        int[] result = new int[n + 1];

        int min = 251;
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <=n; j++){
                if(graph[i][j] != 251){
                    result[i] = Math.max(result[i], graph[i][j]);
                }
            }
            min = Math.min(min, result[i]);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(result[i] == min){
                sb.append(i + " ");
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
        System.out.println(sb);
    }
}
