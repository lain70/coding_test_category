package SortCategory;

import java.util.Scanner;

public class InstallRouter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		
		int n = Integer.valueOf(input[0]);
		int c = Integer.valueOf(input[1]);
		
		int[] routers = new int[n];
		
		for(int i = 0; i < routers.length; i++) {
			routers[i] = Integer.valueOf(sc.nextLine());
		}
		
		
	}
}
