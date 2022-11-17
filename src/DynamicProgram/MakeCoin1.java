package DynamicProgram;

import java.util.Arrays;
import java.util.Scanner;

public class MakeCoin1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int n = Integer.valueOf(input[0]);
		int k = Integer.valueOf(input[1]);
		
		int[] coins = new int[n];
		int[] make = new int [k+1];
		
		for(int i = 0 ; i< n; i++) {
			coins[i] = Integer.valueOf(sc.nextLine());
		}
		
		Arrays.fill(make, 0);
		make[0]= 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = coins[i]; j<=k; j++) {
				make[j] = make[j] + make[j - coins[i]];
			}
		}
		
		System.out.println(make[k]);
		
	}
}
