package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class TermSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] data = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sum = new int[n+1];
        Arrays.fill(sum, 0);
        int sumVal = 0;
        for(int i = 0; i < n; i++){
            sumVal += data[i];
            sum[i+1] = sumVal;
        }

        int left = Integer.valueOf(sc.nextLine());
        int right = Integer.valueOf(sc.nextLine());

        System.out.println(sum[right] - sum[left-1]);
    }
}
