package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KevinBacon {
    final static int MAX = 100*5000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(arr[i], MAX);
            arr[i][i] = 0;
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    if(arr[a][b] > arr[a][k] + arr[k][b]){
                        arr[a][b] = arr[a][k] + arr[k][b];
                    }
                }
            }
        }

        int result = 0;
        int minSum = MAX;
        for(int i = 1; i <=n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                sum += arr[i][j];
            }
            if(minSum > sum){
                minSum = sum;
                result = i;
            }
        }

        System.out.println(result);

    }
}
