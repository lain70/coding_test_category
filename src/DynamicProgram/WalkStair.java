package DynamicProgram;

import java.util.Scanner;

public class WalkStair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine()); 
		int[] stairs = new int[n+1];
		int[] save = new int[n+1];
		
		for(int i = 1; i < n+1; i++) {
			stairs[i] = Integer.valueOf(sc.nextLine());
		}
		
		save[0] = 0;
		save[1] = stairs[1];
		
		if(n > 1) {
			save[2] = stairs[1] + stairs[2];
		}
		
		for (int i = 3; i <= n; i++) {
			save[i] = Math.max(save[i-2], save[i-3] + stairs[i-1]) + stairs[i];
		}
		
		System.out.println(save[n]);
	}
}
