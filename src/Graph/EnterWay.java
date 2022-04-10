package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class EnterWay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int g = Integer.valueOf(sc.nextLine());
		int p = Integer.valueOf(sc.nextLine());
		
		boolean[] gateway = new boolean[g];
		Arrays.fill(gateway, true);
		
		int cnt = 0;		
		for(int i = 0; i < p; i++) {
			int plane = Integer.valueOf(sc.nextLine());
			
			boolean finish = false;
			for(int j = plane - 1; j > -1; j--) {
				if(gateway[j]) {
					cnt++;
					gateway[j] = false;
					finish = true;
					break;
				}
			}
			
			if(!finish) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
}
