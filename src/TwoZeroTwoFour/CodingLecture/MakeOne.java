package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MakeOne {
    public static void main(String[] args) {
        int x;
        Scanner sc = new Scanner(System.in);
        x = Integer.valueOf(sc.nextLine());

        int[] memo = new int[x + 1];
        Arrays.fill(memo, 0);

        for(int i = 2; i < x + 1; i++){
            memo[i] = memo[i - 1] + 1;

            if (i % 2 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }

            if (i % 3 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            }

            if (i % 5 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 5] + 1);
            }
        }

        System.out.println(memo[x]);
    }
}
