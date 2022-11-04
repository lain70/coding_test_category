package Greed;

import java.util.Arrays;
import java.util.Scanner;

public class MinCoinEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        if(n == 1){
            System.out.println(-1);
            return;
        }

        int[] d = new int[n+1];
        Arrays.fill(d,100001);

        int[] coins = new int[]{2,5};

        for(int i = 0; i < 2; i++){
            if(n < coins[i]){
                break;
            }
            int coin = coins[i];
            d[coin] = 1;
            for(int j = coin + 1; j < n+1; j++){

                if(d[j - coin] != 100001){
                    d[j] = Math.min(d[j], d[j - coin] + 1);
                }
            }
        }
        System.out.println(d[n] != 100001?d[n]:-1);
    }
}
