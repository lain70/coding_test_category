package SearchCategory.Lis;

import java.util.Arrays;
import java.util.Scanner;

public class LisBasicRe {
    static int[] arr, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[1001];
        dp[0] = arr[0];

        int dpLen = 1;
        for(int i = 1; i < arr.length; i++){
            if(dp[dpLen - 1] < arr[i]){
                dp[dpLen] = arr[i];
                dpLen++;
            }else{
                bSearch(dpLen, i);
            }
        }

        System.out.println(dpLen);
    }

    public static void bSearch(int len, int idx){
        int start = 0, end = len, mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if(dp[mid] < arr[idx]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        dp[start] = arr[idx];
    }
}
