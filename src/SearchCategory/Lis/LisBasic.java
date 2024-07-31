package SearchCategory.Lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11053
public class LisBasic {
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
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
        System.out.println(dpLen);
    }
    public static void bSearch(int len, int idx){
        int start = 0;
        int end = len;
        while (start <= end){
            int mid = (start + end) / 2;
            if(dp[mid] < arr[idx]){
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        dp[start] = arr[idx];
    }
}
