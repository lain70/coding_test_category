package Greed;

import java.io.IOException;
import java.util.Scanner;

public class MakeCoinSum {
    public static void main(String[] args) throws IOException {
    	int answer = 0;
        //input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int n = Integer.valueOf(inputStr[0]);
        int k = Integer.valueOf(inputStr[1]);
        
        int[] coins = new int[n];
        
        for(int i = 0; i < n; i++) {
        	coins[n-1-i] = Integer.valueOf(scanner.nextLine());
        }
        
        // 가장 큰 수보다 하나씩 대조
        
        for(int i = 0; i < n; i++) {
        	if(coins[i] == k) {
        		answer++;
        		break;
        	}
        	
        	if(coins[i] > k) {
        		continue;
        	}
        	
        	answer += k / coins[i];
        	k = k % coins[i];
        	
        	if(k == 0) {
        		break;
        	}
        	
        }
        //output
        System.out.println(answer);
    }	
}
