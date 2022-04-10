package Etc;

import java.util.Arrays;
import java.util.Scanner;

public class MinTransfer {
	public static int maxSum = 1000001;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] info = sc.nextLine().split(" ");
		int n = Integer.valueOf(info[0]);
		int l = Integer.valueOf(info[1]);
		
		int[][] stations = new int[l+1][n+1];
		for(int[] s : stations) {
			Arrays.fill(s, 0);
		}
		
		for(int i = 1; i < l+1; i++) {
			int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int j = 0; j < input.length - 1; j++) {
				stations[i][input[j]] = 1;
			}
		}
		
		
		
		
	}
}
