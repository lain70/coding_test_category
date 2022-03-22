package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindDistanceCity {
	
	public static List<Integer> result = new ArrayList<>();

	
	public static void main(String[] args) {
		int[] basic = {4,4,1,1};
		
		int[][] arr = {
				{1,2},
				{1,3},
				{2,3},
				{2,4}
		};
		
		boolean[] visited = new boolean[basic[0] + 1];
		Arrays.fill(visited, false);
		
		Queue<int[]> que = new LinkedList<>();		
		
		int[] data = new int[2];
		data[0] = basic[3];
		data[1] = 0;
		que.offer(data);
		
		visited[basic[3]] = true;
		int distance = basic[2];
		while(!que.isEmpty()) {
			
			int[] nowData = que.poll();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i][0] == nowData[0] && !visited[arr[i][1]]) {
					visited[arr[i][1]] = true;
					
					if(nowData[1] + 1 == distance) {
						result.add(arr[i][1]);
					}else {
						int[] newData = new int[2];
						newData[0] = arr[i][1];
						newData[1] = nowData[1] + 1;
						System.out.println("dept : " + (nowData[1] + 1) + " / city :" + arr[i][1]);
						que.offer(newData);
					}
					
				}
			}
		}
		
		if(result.size() < 1) {
			System.out.println(-1);
			return;
		}
		for(int a : result) {
			System.out.println(a);
		}
	

	}
}
