package TopologySort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WorkSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine());
		
		int[] indegree = new int[n+1];
		
		Arrays.fill(indegree, 0);
		
		int[] time  = new int[n+1];		
		Arrays.fill(time, 0);
		
		int[] result = new int[n+1];
		Arrays.fill(result, 0);
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		
		
		for(int i = 1; i <= n; i++) {
			int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			time[i] = input[0];
			result[i] = input[0];
			
			if(input[1] == 0) {
				que.offer(i);		
			}else {
				indegree[i] = input[1];
				for(int j = 2; j <input.length; j++) {
					graph.get(input[j]).add(i);
				}
			}			
		}

		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int next : graph.get(now)) {
				indegree[next]--;
				
				result[next] = Math.max(result[next], result[now] + time[next]);
				
				if(indegree[next] == 0) {
					que.offer(next);
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, result[i]);
		}
		
		System.out.println(max);

	}

}
