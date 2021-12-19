package Implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringReSorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		String pattern = "^[0-9]*$";
		
		int strSum = 0;
		String filterStr = "";
		
		for(String a : input.split("")) {
			if(Pattern.matches(pattern, a)) {
				strSum += Integer.valueOf(a);
			}else {
				filterStr += a;
			}
		}
		
		char[] arr = filterStr.toCharArray();
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder(new String(arr));
		sb.append(strSum);
		
		
		
		System.out.println(sb.toString());
		
	}
}
