package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class CountInArr {
    public static void main(String[] args) {
        int n, m, startIdx = 0, endIdx = 0;
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sel = -1;
        int start = 0, end = n -1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] == m){
                sel = m;
                break;
            }

            if(arr[mid] < m){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(sel == -1){
            System.out.println(sel);
            return;
        }

        // 특정 수의 시작 index 구하기
        start = 0;
        end = sel;
        while (start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] >= m){
                end = end - 1;
            }else{
                startIdx = mid;
                start = mid + 1;
            }
        }

        start = sel;
        end = n-1;
        while (start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] <= m){
                start = mid + 1;
            }else{
                endIdx = mid;
                end = mid - 1;
            }
        }

        System.out.println(endIdx - startIdx - 1);
    }
}
