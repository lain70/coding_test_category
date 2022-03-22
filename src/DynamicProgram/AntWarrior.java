package DynamicProgram;

import java.util.Arrays;

public class AntWarrior {

	public static void attack(int arr, int target) {
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,1,5};
		int[] save = new int[arr.length];
		
		Arrays.fill(save, 0);
		
		save[0] = arr[0];
		save[1] = Math.max(arr[0],arr[1]);
		for(int i = 2; i < arr.length; i++) {
			save[i] = Math.max(arr[i] + save[i-2], save[i-1]);
		}
		
		System.out.println(save[arr.length-1]);
		
	}
}
