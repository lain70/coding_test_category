package SearchCategory.Lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 12014
public class Stock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            int[] dp = new int[10001];

            st = new StringTokenizer(br.readLine());
            int[] stock = new int[day];
            for(int j = 0; j < day; j++){
                stock[j] = Integer.valueOf(st.nextToken());
            }

            dp[0] = stock[0];
            int dpLen = 1;
            for(int c = 1; c < day; c++){
                if(dp[dpLen - 1] < stock[c]){
                    dp[dpLen] = stock[c];
                    dpLen++;
                }else {
                    bSearch(dp, stock, dpLen, c);
                }
            }
            System.out.println("Case #" + (i + 1));
            System.out.println(dpLen >= k?1:0);
        }
    }

    static void bSearch(int[] dp, int[] stock, int len, int idx){
        int start = 0;
        int end = len;
        while (start < end){
            int mid = (start + end) / 2;
            if(dp[mid] < stock[idx]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        dp[start] = stock[idx];
    }
}
