package SortCategory;

public class QuickSort {
	
	public void procSort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			while(left <= end && array[left] <= array[pivot]) {
				left += 1;
			}
			
			while(right > start && array[right] >= array[pivot]) {
				right -= 1;
			}
			
			if(left > right) {
				int swap = array[pivot];
				array[pivot] = array[right];
				array[right] = swap;
			}else {
				int swap = array[right];
				array[right] = array[left];
				array[left] = swap;
			}
		}
		
		procSort(array, start, right - 1);
		procSort(array, right + 1, end);
		
		
	}

	public static void main(String[] args) {
		int[] array = {5,7,9,0,3,1,6,2,4,8};
		
		QuickSort qs = new QuickSort();
		qs.procSort(array, 0, array.length - 1);
		
		for(int a : array) {
			System.out.print(a + ", ");	
		}
		
	}
}
