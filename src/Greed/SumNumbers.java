package Greed;

import java.util.Scanner;

//백준 1789번
//1부터 1씩 증가시킨 합이 s가 되면 가장 많은 자연수의 합이 된다.
//로직은 200에서 1씩 빼나가는 방식으로 만든다.
public class SumNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long s = Long.valueOf(sc.nextLine());
		long div = 0;
		while(s > div) {
			div++;
			s -= div;
		}
		
		System.out.println(div);
	}
}
