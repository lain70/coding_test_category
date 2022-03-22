package SearchCategory;

import java.util.Arrays;

public class MakeDDuk {

	public static void main(String[] args) {
		int arr[] = {19,15,10,17};
		
		int start = 0;
		Arrays.sort(arr);
		int end = arr[arr.length-1];
		
		int target = 6;
		int max = 0;
		int mid = 0;
		while(start < end) {
			
			mid = (start + end) / 2;			
			int sum = 0;
			for(int a : arr) {
				if(a - mid > 0) {
					sum += (a - mid);	
				}				
			}
			
			if(sum == target) {
				break;
			}else if(sum < target) { 
				end = mid - 1;
			}else if(sum > target){
				start = mid + 1;
			}
		}
		
		System.out.println(mid);
	}
}
