package Implementation;

import java.util.Scanner;

public class KroatiaAlphabat {

	public static void main(String[] args) {
		String[] kroAlphabat = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		int answer = 0;
		for(String a : kroAlphabat) {
			if (input.contains(a)) {
				int originLength = input.length();
				input = input.replaceAll(a, "");
				int afterLength = input.length();

				int cnt = (originLength - afterLength) / a.length();
				answer += cnt;

			}
		}
		
		if(input.length() > 0) {
			answer += input.split("").length;
		}
		
		System.out.println(answer);
	}
}
