package SearchCategory.Lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Semiconductor {
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1];
        dp[0] = arr[0];

        int dpLen = 1;
        for(int i = 1; i < n; i++){
            if(dp[dpLen-1] < arr[i]){
                dp[dpLen] = arr[i];
                dpLen++;
            }else{
                bSearch(dpLen, arr[i]);
            }
        }

        System.out.println(dpLen);
    }

    static void bSearch(int len, int target){
        int start = 0;
        int end = len;
        while (start <= end){
            int mid = (start + end) / 2;

            if(dp[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        dp[start] = target;
    }
}
