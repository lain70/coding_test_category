package Etc;

import java.util.Arrays;
import java.util.Scanner;

public class NPrimaryNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        boolean[] boolPrime = new boolean[n+1];
        Arrays.fill(boolPrime,true);
        boolPrime[0] = false;
        boolPrime[1] = false;

        for(int i = 2; i < Math.sqrt(n); i++){
            int j = 2;
            while (i * j <= n){
                boolPrime[i * j] = false;
                j++;
            }
        }

        int i = 0;
        for(boolean bp : boolPrime){
            if(bp){
                System.out.print(i + " ");
            }
            i++;
        }
    }
}
