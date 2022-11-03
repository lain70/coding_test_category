package SearchCategory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NMakeDbk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());
        int[] dduk = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = Arrays.stream(dduk).max().getAsInt();
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            int sum = 0;
            for(int d : dduk){
                if(d > mid){
                    sum += d - mid;
                }
            }
            if(sum < m){
                end = mid - 1;
            }else {
                start = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
