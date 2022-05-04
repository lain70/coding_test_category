package DynamicProgram;

import java.util.Scanner;

public class DrinkWine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		int[] wine = new int[n];
		
		for(int i = 0; i < n; i++) {
			wine[i] = Integer.valueOf(sc.nextLine());
		}
		
		int[] save = new int[n];
		
		if(n >= 1) {
			save[0] = wine[0];
		}
		
		if(n >=2) {
			save[1] = wine[0] + wine[1];
		}
		
		if(n >=3) {
			save[2] = Math.max(save[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]) );
		}
		
		for(int i = 3; i < n; i++) {
			save[i] = Math.max(save[i -1], Math.max(save[i-2] + wine[i], save[i-3] + wine[i-1] + wine[i]));
		}
		
		System.out.println(save[n-1]);
	}
}
