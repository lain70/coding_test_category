package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MakeDuck {
    public static void main(String[] args) {
        int n, m, result= 0;
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int start = 0, end = arr[n-1], mid = 0;
        while (start <= end){
            mid = (start + end) / 2;

            int cnt = 0;
            for(int a : arr){
                cnt += a - mid > 0? a - mid : 0;
            }

            if(cnt < m){
                end = mid -1;
            }else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
