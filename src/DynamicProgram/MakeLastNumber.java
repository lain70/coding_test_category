package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 5557
//최대값은 20 즉 i 번째 가능한 숫자에 갯수를 표기한다.
public class MakeLastNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;

        int plus = 0;
        int minus = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = 0; j<21; j++){
                if(dp[i-1][j] != 0){
                    plus = j + arr[i];
                    minus = j - arr[i];

                    if(plus <= 20){
                        dp[i][plus] += dp[i-1][j];
                    }

                    if(minus >= 0){
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);
    }
}
