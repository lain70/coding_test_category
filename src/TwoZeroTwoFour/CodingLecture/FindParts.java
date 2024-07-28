package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class FindParts {
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        int[] parts = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.valueOf(sc.nextLine());
        int[] srch =  Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(parts);
        for(int s : srch){
            System.out.print(binarySrch(parts, s) + " ");
        }
    }

    private static String binarySrch(int[] arr, int target){
        int start = 0;
        int end = arr.length;
        String result = "no";
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target){
                result = "yes";
                break;
            }

            if(target < arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return result;
    }
}
