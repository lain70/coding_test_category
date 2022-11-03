package DynamicProgram;

import java.util.Arrays;
import java.util.Scanner;

public class NMakeTile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        int[] d = new int[n+1];
        Arrays.fill(d,0);
        if(n == 1){
            System.out.println("1");
        }else if(n == 2){
            System.out.println("3");
        }else{
            d[1] = 1;
            d[2] = 3;

            for(int i = 3; i <= n; i++){
                d[i] = (d[i-1] + 2*d[i-2])%796796;
            }
        }

        System.out.println(d[n]);

    }
}
