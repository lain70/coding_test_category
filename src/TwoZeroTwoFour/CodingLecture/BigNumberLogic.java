package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumberLogic {
    public static void main(String[] args) {
        int n, m, k;
        int[] arr;

        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        k = input[2];
        arr = new int[n];
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] orderArr = Arrays.stream(arr).distinct().sorted().toArray();

        int result = 0;
        int j = 0;
        for(int i = 0; i < m; i++){
            if(j < k){
                result += orderArr[orderArr.length - 1];
                j++;
            } else {
                result += orderArr[orderArr.length - 2];
                j = 0;
            }
        }

        System.out.println(result);
    }
}
