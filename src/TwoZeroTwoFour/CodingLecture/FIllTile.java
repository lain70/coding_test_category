package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class FIllTile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        int[] memo = new int[n+1];
        Arrays.fill(memo, 0);
        memo[1] = 1;
        memo[2] = 3;
        for(int i = 3; i < n+1; i++){
            memo[i] = (memo[i - 1] + memo[i - 2] * 2) % 796796;
        }

        System.out.println(memo[n]);
    }
}
