package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 11067
public class AesNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][20];


        for(int i = 0; i< 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 10; j++){
                for(int k = j; k < 10; k++){
                    dp[i+1][k] = (dp[i+1][k] + dp[i][j])%10007;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++){
            result += (dp[n][i]%10007);
        }
        System.out.println(result%10007);

    }
}
