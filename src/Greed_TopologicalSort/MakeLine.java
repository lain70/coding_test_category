package Greed_TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// น้มุ2252
public class MakeLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		int[] first = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] indegree = new int[first[0]+1];
		Arrays.fill(indegree, 0);
		
		for(int i = 0; i < first[0]+1; i++) {			
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < first[1]; i++) {
			int[] now = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();			
			graph.get(now[0]).add(now[1]);
			
			indegree[now[1]]++;			
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!que.isEmpty()) {
			int now = que.poll();			
			for(int i = 0; i < graph.get(now).size(); i++) {
				indegree[graph.get(now).get(i)] -= 1;
				
				if(indegree[graph.get(now).get(i)] == 0) {
					que.offer(graph.get(now).get(i));
				}
			}
			
			if(!que.isEmpty()) {
				sb.append(now + " ");
			}else {
				sb.append(now);
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
