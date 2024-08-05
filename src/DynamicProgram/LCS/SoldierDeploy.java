package DynamicProgram.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SoldierDeploy {
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()){
            arr[i] = Integer.valueOf(st.nextToken());
            i++;
        }

        dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = arr[0];

        int len = 1;
        for(int j = 1; j < arr.length; j++){
            if(dp[len - 1] > arr[j]){
                dp[len] = arr[j];
                len++;
            }else {
                bSearch(len, arr[j]);
            }
        }

        int cnt = 0;
        for(int d : dp){
            if(d == 0){
                break;
            }
            cnt++;
        }

        System.out.println(n - cnt);
    }

    static void bSearch(int len, int target){
        int start = 0;
        int end = len;

        while (start < end){
            int mid = (start + end) / 2;
            if(dp[mid] > target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        dp[start] = target;
    }
}
