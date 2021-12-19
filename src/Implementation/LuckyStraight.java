package Implementation;

import java.util.Scanner;

public class LuckyStraight {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String score = sc.nextLine();
		
		String[] first = score.substring(0, score.length() / 2).split("");
		String[] second = score.substring(score.length() / 2, score.length()).split("");
		
		int firstSum = 0;
		int secondSum = 0;
		for(int i = 0; i < first.length; i++) {
			firstSum += Integer.valueOf(first[i]);
			secondSum += Integer.valueOf(second[i]);
		}
		
		if(firstSum == secondSum) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
	}
}
