package Greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ImpossibleAmount {
	public static void main(String[] args) {
		List<Integer> possibleAmount = new ArrayList<>();
		int result = 1;
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); sc.nextLine();
		int[] arr = new int[n];
		
		arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer:: parseInt).toArray();		
		// 순서대로 정렬
		Arrays.sort(arr);
		
		for(int a : arr) {
			if(result < a) {
				break;
			}else {
				result += a;
			}
		}
		
		System.out.println("result : " + result);
		
	}
}
