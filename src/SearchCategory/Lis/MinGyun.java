package SearchCategory.Lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//backjoon 11568
public class MinGyun {
    static int n;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        arr = new int[n];
        dp = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        dp[0] = arr[0];
        int dpLen = 1;
        for(int i = 1; i < n; i++){
            if(dp[dpLen-1] < arr[i]){
                dp[dpLen] = arr[i];
                dpLen++;
            }else{
                bSearch(dpLen, i);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] > 0){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bSearch(int end, int target){
        int start = 0;
        while (start < end) {
            int mid = (start + end) / 2;

            if(dp[mid] < arr[target]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        dp[start] = arr[target];
    }
}
