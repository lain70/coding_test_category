package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MakeCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        int[] coin = new int[n];
        for(int i = 0; i < n; i++){
            coin[i] = Integer.valueOf(sc.nextLine());
        }

        // 메모리 채우기
        int[] d = new int[m+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        for (int i = 0; i < n; i++) {
            for(int j = coin[i]; j < m + 1; j++){
                if(d[j - coin[i]] != Integer.MAX_VALUE){
                    d[j] = Math.min(d[j], d[j - coin[i]] + 1);
                }
            }
        }

        System.out.println((d[m] != Integer.MAX_VALUE ? d[m] : -1));
    }
}
