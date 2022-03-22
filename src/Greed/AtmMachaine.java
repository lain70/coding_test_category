package Greed;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//น้มุ 11399
public class AtmMachaine {
	
	    public static void main(String[] args) throws IOException {
	        //input
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        scanner.nextLine();
	        int[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	        
	        Arrays.sort(p);
	        
	        int[] save = new int[p.length];
	        
	        save[0] = p[0];
	        
	        for(int i = 1; i < p.length; i++) {
	        	save[i] = save[i-1] + p[i];
	        }
	        
	        int answer = 0;
	        for(int a : save) {
	        	answer += a;
	        }

	        //output
	        System.out.println(answer);
	    }	

}
