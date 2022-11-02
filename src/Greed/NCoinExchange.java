package Greed;

import java.util.Scanner;

public class NCoinExchange {
    public static void main(String[] args) {
        int[] coin = new int[]{500,100,50,10};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        for(int c : coin){
            result += n/c;
            n %= c;
        }

        System.out.println(result);

    }
}
