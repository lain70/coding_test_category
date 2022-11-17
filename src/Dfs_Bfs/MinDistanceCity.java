/**
 * 백준 18352
 */
package Dfs_Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinDistanceCity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		
		int n = Integer.valueOf(input[0]);
		int m = Integer.valueOf(input[1]);
		int k = Integer.valueOf(input[2]);
		int x = Integer.valueOf(input[3]);
		
		int[] distance = new int[n+1];
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
			distance[i] = -1;
		}
		distance[x] = 0;
		
		for(int i = 0; i < m; i++) {
			String[] info = sc.nextLine().split(" ");
			list.get(Integer.valueOf(info[0])).add(Integer.valueOf(info[1]));
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(x);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i = 0 ; i < list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				if(distance[next] == -1) {
					distance[next] = distance[now] + 1;
					que.offer(next);
				}
			}
		}
		
		boolean chck = false;
		
		for(int i = 1; i < distance.length; i++) {
			if(distance[i] == k) {
				System.out.println(i);
				chck = true;
			}
		}
		
		if(!chck) {
			System.out.println(-1);
		}
		
		
	}
}
