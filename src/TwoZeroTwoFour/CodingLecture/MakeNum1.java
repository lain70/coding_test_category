package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MakeNum1 {
    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        k = input[1];

        int cnt = 0;
        while (n != 1){
            if (n % k > 0) {
                n--;
            } else {
                n = n / k;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
