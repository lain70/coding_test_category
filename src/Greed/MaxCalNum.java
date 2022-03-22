package Greed;

import java.util.Scanner;

public class MaxCalNum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] divMinus = input.split("\\-");
		
		int answer = 0;
		for(int i = 0; i < divMinus.length; i++) {
			
			String[] divPlus = divMinus[i].split("\\+");
			int now = 0;
			for(String b : divPlus) {
				now += Integer.valueOf(b);
			}
			if(i != 0) {
				now *= -1;
			}
			
			answer += now;
		}
		
		System.out.println(answer);
	}
}
