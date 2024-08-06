package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HeightArr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for(boolean[] ar : arr){
            Arrays.fill(ar, false);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.valueOf(st.nextToken())][Integer.valueOf(st.nextToken())] = true;
        }

        for(int k = 1; k < n + 1; k++){
            for(int a = 1; a < n + 1; a++){
                for(int b = 1; b < n + 1; b++){
                    if(arr[a][k] && arr[k][b]){
                        arr[a][b] = true;
                    }
                }
            }
        }

        int[] cnt = new int[n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] || arr[j][i]) cnt[i]++;
            }
        }

        int result = 0;
        for(int num : cnt){
           if(num == n -1) result++;
        }

        System.out.println(result);
    }
}
