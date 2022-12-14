package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2565
// dp + LIS lis에 대해 잘 알아두자
public class ElectricWire {
    static int[] poles, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        poles = new int[501];
        dp = new int[101];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            poles[a] = b;
        }

        int dpLen = 1;

        for(int i = 1; i < poles.length; i++){
            if(poles[i] != 0){
                if(dp[dpLen - 1] < poles[i]){
                    dp[dpLen++] = poles[i];
                }else{
                    bSearch(dpLen, i);
                }
            }
        }

        System.out.println(n - dpLen + 1);
    }

    public static void bSearch(int dpLen, int idx){
        int start = 0;
        int end = dpLen;
        while (start <= end){
            int mid = (start + end) / 2;

            if(dp[mid] < poles[idx]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        dp[start] = poles[idx];
    }

}
