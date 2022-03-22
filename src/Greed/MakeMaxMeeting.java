package Greed;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//น้มุ 1931
public class MakeMaxMeeting {
	public static void main(String[] args) throws IOException {    	
        //input
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
        	
		});
        
        for(int i = 0; i < n; i++) {
        	pq.offer(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        
        int answer = 0;
        int prev = 0;
        while(!pq.isEmpty()) {
        	int[] now = pq.poll();
        	
        	if(prev <= now[0]) {
        		prev = now[1];
        		answer++;
        	}
        }

        System.out.println(answer);
    }	
}