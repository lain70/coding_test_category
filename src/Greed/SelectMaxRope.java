package Greed;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// น้มุ2217
public class SelectMaxRope {
	public static void main(String[] args) throws IOException {    	
        //input
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.valueOf(sc.nextLine());
        
        int[] rope = new int[n];        
        
        for(int i = 0; i < n; i++) {
        	rope[i] = Integer.valueOf(sc.nextLine());
        }
        
        Arrays.sort(rope);
        
        int max = 0;
        for(int i = 0; i < rope.length; i++) {
        	max = Math.max(max, rope[i] * (n - i));
        }

        System.out.println(max);
    }	
}
