package Graph_Floyd_Warshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HeightFind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for(boolean[] ar : arr){
            Arrays.fill(ar, false);
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            arr[a][b] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        int[] cntSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i][j] || arr[j][i]){
                    cntSum[i]++;
                }
            }
        }

        int result = 0;
        for(int cnt : cntSum){
            if(cnt == n-1) result++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
/*
6 6
1 5
3 4
5 4
4 2
4 6
5 2
 */