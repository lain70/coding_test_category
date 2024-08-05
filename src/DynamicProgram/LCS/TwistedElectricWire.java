package DynamicProgram.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwistedElectricWire {
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
            dp[i] = 0;
        }

        dp[0] = arr[0];

        int len = 1;
        for(int i = 1; i < n; i++){
            if(dp[len - 1] < arr[i]){
                dp[len] = arr[i];
                len++;
            }else{
                bSearch(len, arr[i]);
            }
        }

        for(int i = 0; i < n; i++){
            if(dp[i] == 0){
                System.out.println(n - i);
                break;
            }
        }
    }

    static void bSearch(int len , int target){
        int start = 0, end = len;
        while (start < end){
            int mid = (start + end) / 2;

            if(dp[mid] < target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        dp[start] = target;
    }
}
