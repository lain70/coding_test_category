package Greed;

import java.util.Scanner;

public class MultiOrPlus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		int result = 0;		
		for (String a : input.split("")) {
			if(result == 0) {
				result +=Integer.valueOf(a);
				continue;
			}
			
			if(Integer.valueOf(a) == 0 || Integer.valueOf(a) == 1) {
				result += Integer.valueOf(a);
			}else {
				result *= Integer.valueOf(a);
			}			
		}
		
		System.out.println(result);
	}
}
