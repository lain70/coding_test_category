package Greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CupRamen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		Long[][] rewards = new Long[n][2];
		
		for(int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(" ");
			rewards[i][0] = Long.valueOf(input[0]);
			rewards[i][1] = Long.valueOf(input[1]);
		}
		
		Arrays.sort(rewards, new Comparator<Long[]>() {
			@Override
			public int compare(Long[] o1, Long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});
		
				
	}
}
