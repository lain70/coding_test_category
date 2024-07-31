package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class EratosthenesBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        boolean[] result = new boolean[n + 1];
        Arrays.fill(result, true);

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(result[i]){
                int j = 2;
                while (i * j <= n){
                    result[i * j] = false;
                    j += 1;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            if(result[i]){
                System.out.print(i + " ");
            }
        }
    }
}
