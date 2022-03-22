package Greed;

import java.util.PriorityQueue;
import java.util.Scanner;

//น้มุ 1715
public class SortMaxCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			pq.offer(Integer.valueOf(sc.nextLine()));
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			int a = pq.poll();
			int b = 0;
			if(!pq.isEmpty()) {
				b = pq.poll();
				answer += a + b;
				if(!pq.isEmpty()) {
					pq.offer(a + b);	
				}				
			}
			
		}
		
		System.out.println(answer);		
	}
}
