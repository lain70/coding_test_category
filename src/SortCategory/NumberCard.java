package SortCategory;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine());

		int[] base = new int[n];

		base = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(base);

		int m = Integer.valueOf(sc.nextLine());

		int[] search = new int[m];

		search = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] result = new int[m];

		int i = 0;
		for (int s : search) {
			if(binarySearch(base, s)) {
				result[i] = 1;
			}else {
				result[i] = 0;
			}
			i++;
		}
		
		for(int r : result) {
			System.out.print(r + " ");
		}
	}

	public static boolean binarySearch(int[] number, int search) {
		boolean result = false;
		int start = 0;
		int end = number.length;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(number[mid] == search) {
				result = true;
				break;
			}
			
			if(number[mid] < search) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return result;
	}
}
