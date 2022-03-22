package Greed_TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//น้มุ 1516
public class MakeGameBuildTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		int[] indegree = new int[n+1];
		int[] time = new int[n+1];
		int[] result = new int[n+1];
		Arrays.fill(indegree, 0);
		
		ArrayList<ArrayList<Integer>> data = new ArrayList<>();
		for(int i = 0; i < n + 1; i++) {
			data.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i < n + 1; i++) {
			int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(info.length == 2) {				
				time[i] = info[0];
				result[i] = info[0];
			}else if(info.length > 2){
				time[i] = info[0];
				result[i] = info[0];
				for(int j = 1; j <info.length - 1; j ++) {
					indegree[i]++;
					data.get(info[j]).add(i);
				}
			}			
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()) {
			int temp = que.poll();			
			
			for(int i = 0; i < data.get(temp).size(); i++) {
				indegree[data.get(temp).get(i)] -= 1;				
				result[data.get(temp).get(i)] = Math.max(result[data.get(temp).get(i)], result[temp] + time[data.get(temp).get(i)]);				
				
				if(indegree[data.get(temp).get(i)] == 0) {
					que.offer(data.get(temp).get(i));
				}
			}
		}
		
		for(int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}		
	}
}
