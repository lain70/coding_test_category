package SearchCategory.BinarySearchCate;

public class BinarySearch {	

	public static void main(String[] args) {
		int result = 0;
		
		int[] arr = {0,1,4,7,8,9,11,13};
		
		int start = 0;
		int end = arr.length;
		
		int target = 11;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(target == arr[mid]) {
				result = mid;
				break;
			}else if(target < arr[mid]) {
				end = mid - 1;
			}else if(target > arr[mid]){
				start = mid + 1;
			}
		}
		
		System.out.println(result);
		
	} 
	
}
