package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1719
public class Tackbae {
    public static void main(String[] args) throws IOException {
        int INF = 200 * 1000 + 1; // 최대 소요시간 + 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[][] map = new int[n+1][n+1];
        int[][] passMap = new int[n+1][n+1];
        boolean[][] routes = new boolean[n+1][n+1];

        for(int i =1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i == j){
                    map[i][j] = 0;
                }else{
                    map[i][j] = INF;
                }
                passMap[i][j] = 0;
                routes[i][j] = false;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
            map[b][a] = c;
            passMap[a][b] = b;
            passMap[b][a] = a;
        }

        for(int k = 1; k < n+1; k++){
            for(int a = 1; a < n+1; a++){
                for(int b = 1; b < n+1; b++){
                    if(a == k || b ==k || a==b){
                        continue;
                    }
                    if(map[a][b] > map[a][k] + map[k][b] && routes[a][k] && routes[k][b]){
                        map[a][b] = map[a][k] + map[k][b];
                        passMap[a][b] = k;
                    }
                }
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j< n+1; j++){
                System.out.print((i==j?"-":passMap[i][j]) + " ");
            }
            System.out.println("");
        }
    }
}
