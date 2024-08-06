package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ContinuitySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(arr, Integer.MIN_VALUE);
        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        dp[n - 1] = arr[n - 1];
        int result = arr[n - 1];
        for(int i = n - 2; i > -1; i--){
            if(arr[i] >= dp[i + 1] + arr[i]){
                dp[i] =  arr[i];
            }else{
                dp[i] = dp[i + 1] + arr[i];
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
