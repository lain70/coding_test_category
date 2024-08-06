package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11404
public class CityBus {
    public static void main(String[] args) throws IOException {
        int INF = 100000 * 100 + 1;    //최대가능한 비용 + 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == j){
                    map[i][j] = 0;
                }else{
                    map[i][j] = INF;
                }
            }

        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(map[a][b] > c){
                map[a][b] = c;
            }
        }

        for(int k = 1; k < n+1; k++){
            for(int a = 1; a < n+1; a++){
                for(int b = 1; b < n + 1; b++){
                    if(a !=k && b !=k && a != b){
                        if(map[a][b] > map[a][k] + map[k][b]) {
                            map[a][b] = map[a][k] + map[k][b];
                        }
                    }
                }
            }
        }

        for (int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(map[i][j] >= INF) map[i][j] =0;
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
