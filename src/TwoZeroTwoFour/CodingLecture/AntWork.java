package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class AntWork {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] memo = new int[n];

        Arrays.fill(memo, 0);

        memo[0] = arr[0];
        memo[1] = arr[1];
        for(int i = 2; i < n; i++){
            memo[i] = Math.max(arr[i] + memo[i-2], memo[i-1]);
        }

        System.out.println(memo[n-1]);
    }
}
