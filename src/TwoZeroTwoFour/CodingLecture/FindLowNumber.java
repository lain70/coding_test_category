package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class FindLowNumber {
    public static void main(String[] args) {
        int n,m;
        int[][] cardArr;
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        cardArr = new int[n][m];
        for(int i = 0; i < n; i++){
            cardArr[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;
        for(int[] cards : cardArr){
            result = Math.max(result, Arrays.stream(cards).min().getAsInt());
        }

        System.out.println(result);
    }
}
