package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeNumberOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];
        Arrays.fill(dp, x+1);
        dp[x] = 0;
        for(int i = x; i >=2; i--){
            if(dp[i] < x+1){
                if(i % 3 == 0){
                    dp[i/3] = Math.min(dp[i/3], dp[i]+1);
                }
                if(i % 2 == 0){
                    dp[i/2] = Math.min(dp[i/2], dp[i]+1);
                }

                dp[i-1] = Math.min(dp[i-1], dp[i]+1);
            }
        }
        System.out.println(dp[1]);

    }
}
