package Greed;

import java.util.Arrays;
import java.util.Scanner;

public class SelectBowlingBall {
	
	public int select(int n, int m, int[] inputVal) {
		int result = 0;
		int[]bollWeight = new int[m+1];
		Arrays.fill(bollWeight, 0);
		
		for(int a : inputVal) {
			bollWeight[a] ++;
		}
		
		for(int b : bollWeight) {
			n -= b;
			result += n*b;
		}
		
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, m;
		int[] inputVal;
		int[] sumArr;
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer:: parseInt).toArray();
		
		n = arr[0];
		m = arr[1];
		
		inputVal = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer:: parseInt).toArray();
		
		Arrays.sort(inputVal);
		
		sumArr = new int[m + 1];
		Arrays.fill(sumArr, 0);
		
		int sameCnt = 1;
		for(int i = 0; i < inputVal.length - 1; i++) {
			
			if(inputVal[i] == inputVal[i+1]) {
				sameCnt++;
				continue;
			}else {
				sumArr[inputVal[i]] = ((inputVal.length - 1) - i) * sameCnt;
				sameCnt = 1;
			}
			
		}
		
//		System.out.println(Arrays.stream(sumArr).sum());
		SelectBowlingBall sbb = new SelectBowlingBall();
		System.out.println(sbb.select(n, m, inputVal));
		
				
	}
}
