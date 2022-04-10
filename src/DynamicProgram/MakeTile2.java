package DynamicProgram;

import java.util.Scanner;

public class MakeTile2 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n % 2 == 1) {
        	System.out.println(0);
        	return;
        }
        int [] dp = new int[n+1];
 
        dp[0] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = 3*dp[i-2];
            for(int j=i-4; j>=0; j-=2)
                dp[i]+=2*dp[j];
        }
        System.out.println(dp[n]);
	}
}
