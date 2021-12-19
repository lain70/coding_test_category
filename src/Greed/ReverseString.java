package Greed;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		int zero = 0;
		int one = 0;
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String now = "";
		String[] arr = input.split("");
		for(int i = 0; i < arr.length; i++) {
			if("".equals(now)) {
				now = arr[i];
				continue;
			}
			
			if(!now.equals(arr[i]) || (i == arr.length - 1)) {
				if("0".equals(now)) {
					zero++;
				}else {
					one++;
				}
				now = arr[i];
			}
		}
		
		System.out.println(zero + " / " + one + " / " + Math.min(zero, one));
	}
}
