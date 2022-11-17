package DynamicProgram;

import java.util.Scanner;

public class WaceTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		int[] input = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			int now = Integer.valueOf(sc.nextLine());
			input[i] =  now;
			max = Math.max(max, now);
		}
		
		long[] save = new long[101];
		save[0] = 0;
		save[1] = 1;
		save[2] = 1;
		save[3] = 1;
		save[4] = 2;
		save[5] = 2;
		
		for(int i = 6; i <= 100; i++) {
			save[i] = save[i-1] + save[i-5];
		}
		
		for(int t : input) {
			System.out.println(save[t]);	
		}
				
	}
}
