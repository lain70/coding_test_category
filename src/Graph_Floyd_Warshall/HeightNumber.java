package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HeightNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(arr[i], false);
        }
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            arr[a][b] = true;
        }

        for(int k = 1; k <=n; k++){
            for(int a = 1; a <=n; a++){
                for(int b = 1; b <=n; b++){
                    if (arr[a][k] && arr[k][b]) {
                        arr[a][b] = true;
                    }
                }
            }
        }

        int[] cnt = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] || arr[j][i]){
                    cnt[i]++;
                }
            }
        }

        int result = 0;
        for(int c : cnt){
            if(c == n - 1){
                result++;
            }
        }
        System.out.println(result);
    }
}
