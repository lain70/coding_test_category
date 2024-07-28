package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchBasic {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = n;
        int mid;
        while (start <= end){
            mid = (start + end) / 2;
            if(arr[mid] == m){
                System.out.println(mid + 1);
                break;
            }

            if(arr[mid] > m){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("no result");

    }
}
