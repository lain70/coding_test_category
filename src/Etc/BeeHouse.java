package Etc;

import java.util.Scanner;

public class BeeHouse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		if(n == 1) {
			System.out.println(1);	
		}else {
			int k = 1;
			int i = 1;		
			while(true) {
				k = k + 6*i;
				
				if(n <= k) {
					break;
				}
				i++;
			}
			
			System.out.println(i+1);
		}
	}
}
