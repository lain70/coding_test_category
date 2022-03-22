package Greed_TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//น้มุ 1766น๘
public class ProblemSolving {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] indegree = new int[info[0] + 1];
		Arrays.fill(indegree, 0);

		List<ArrayList<Integer>> data = new ArrayList<>();
		for (int i = 0; i < info[0] + 1; i++) {
			data.add(new ArrayList<>());
		}

		for (int i = 0; i < info[1]; i++) {
			int[] now = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			data.get(now[0]).add(now[1]);
			
			indegree[now[1]]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		StringBuilder result = new StringBuilder();
		while(!pq.isEmpty()) {
			int temp = pq.poll();
			
			for(int i = 0; i < data.get(temp).size(); i++) {
				indegree[data.get(temp).get(i)] -= 1;
				
				if(indegree[data.get(temp).get(i)] == 0) {
					pq.offer(data.get(temp).get(i));
				}
			}
			
			if(!pq.isEmpty()) {
				result.append(temp + " ");
			}else {
				result.append(temp);
			}
		}
		
		System.out.println(result.toString());
	}
}
