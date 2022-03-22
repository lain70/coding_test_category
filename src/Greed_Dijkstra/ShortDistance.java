package Greed_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.distance, o.distance);
	}	
	
}

public class ShortDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		int v = Integer.valueOf(input[0]);
		int e = Integer.valueOf(input[1]);
		
		int start = Integer.valueOf(sc.nextLine());
		
		int[] d = new int[v+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int i = 0; i < e; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < e; i++) {
			int[] nowNode = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();			
			graph.get(nowNode[0]).add(new Node(nowNode[1], nowNode[2]));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node tempNode = pq.poll();
			int now = tempNode.getIndex();	// 현재노드
			int distance = tempNode.getDistance();	//현재 노드 까지 가중치
			
			//현재 노드가 이미 처리된 적이 있으면 무시
			if(d[now] < distance) continue;
			
			//현재 노드와 연결된 인접 노드 확인
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//현재 노드를 거쳐서, 다른 노드로 가는 길이가 더 짧은 경우
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
		
		for(int i = 1; i < d.length; i++) {
			if(d[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(d[i]);
			}
		}
	}
}
