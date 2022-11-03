package DynamicProgram;

import java.util.Arrays;
import java.util.Scanner;

public class NMakeMaxCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.valueOf(sc.nextLine());
        }

        int[] d = new int[m+1];
        Arrays.fill(d, 100001);

        for(int i = 0; i < n; i++){
            int nowCoin = coins[i];
            if(nowCoin > m ){
                break;
            }
            d[nowCoin] = 1;
            for(int j = nowCoin + 1; j < m+1; j++){
                if(d[j-nowCoin] != 100001){
                    d[j] = Math.max(d[j],d[j-nowCoin] + 1);
                }
            }
        }

        System.out.println(d[m] == 100001?-1:d[m]);

    }
}
