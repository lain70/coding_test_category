package SearchCategory;

import java.util.Arrays;
import java.util.Scanner;

public class MakeMinDiv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		
		int n = Integer.valueOf(input[0]);
		int m = Integer.valueOf(input[1]);
		
		int[] arr = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0 ; i < n; i++) {			
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		int start = 0;
		int end = max - min;	// 배열 내에 최대값 - 최소값
		while(start <= end) {
			int mid = (start + end) / 2;
			if(psblDiv(mid, m, arr)) {	//나누기가 가능하면 최대값을 줄임
				end = mid - 1;
			}else {
				start = mid + 1;
			}
			
		}
		
		System.out.println(start);
		
	}
	
	public static boolean psblDiv(int mid, int m, int[] arr) {
		int divCnt = 1;
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			if((max - min) > mid) {
				min = arr[i];
				max = arr[i];
				divCnt++;
				if(divCnt > m) return false;
			}
		}
		
		return true;
		
	}
}
