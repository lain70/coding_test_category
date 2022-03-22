package Greed;

import java.util.Arrays;
import java.util.Scanner;

//น้มุ 13305
public class GasStation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		int[] distance = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] fee = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Long answer = 0l;
		Long minFee = Long.MAX_VALUE;
		for(int i = 0; i < fee.length - 1; i++) {
			minFee = Math.min(minFee, fee[i]);
			answer += minFee * distance[i];
		}
		
		System.out.println(answer);
	}
}
