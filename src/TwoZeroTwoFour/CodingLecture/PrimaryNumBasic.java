package TwoZeroTwoFour.CodingLecture;

import java.util.Scanner;

public class PrimaryNumBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        for(int i = 2; i < (int)(Math.sqrt(n) + 1); i++){
            if(n % i == 0){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
