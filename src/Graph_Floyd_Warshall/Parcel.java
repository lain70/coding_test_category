package Graph_Floyd_Warshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Parcel {
    static int MAX_COST = 200 * 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        int[][] costs = new int[n + 1][n + 1];
        int[][] stopovers = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j){
                    map[i][j] = MAX_COST;
                    costs[i][j] = MAX_COST;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            map[x][y] = cost;
            map[y][x] = cost;
            costs[x][y] = cost;
            costs[y][x] = cost;
            stopovers[x][y] = y;
            stopovers[y][x] = x;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (a != b && a != k && b != k) {
                        if (map[a][b] > map[a][k] + map[k][b]) {
                            map[a][b] = map[a][k] + map[k][b];
                        }
                    }
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (a != b && a != k && b != k) {
                        if (costs[a][b] > map[a][k] + map[k][b]) {
                            costs[a][b] = map[a][k] + map[k][b];
                            stopovers[a][b] = k;
                        }
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    bw.write("- ");
                }else {
                    bw.write(String.valueOf(stopovers[i][j] + " "));
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
