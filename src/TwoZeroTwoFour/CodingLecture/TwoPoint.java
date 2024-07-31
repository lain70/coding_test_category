package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class TwoPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1];

        int[] data = new int[n];
        data = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int end = 0, sum = 0, cnt =0;

        for(int start = 0; start < n; start++){
            while ( sum < m && end < n){
                sum += data[end];
                end += 1;
            }
            if(sum == m){
                cnt += 1;
            }
            sum -= data[start];
        }

        System.out.println(cnt);
    }
}
