package DikstraCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	
	int index;
	int distance;
	
	

	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}


	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.distance, o.distance);
	}
	
}

public class MeetParty {
	
	public static final int maxDistance = 101;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		int n = Integer.valueOf(input[0]);
		int m = Integer.valueOf(input[1]);
		int x = Integer.valueOf(input[2]);
		
		int[] d = new int[n+1];
		Arrays.fill(d, maxDistance);
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		for(int i = 0; i <= m; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		
		for(int i = 0; i < m; i++) {
			int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph.get(info[0]).add(new Node(info[1], info[2])); 
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(x,0));
		d[x] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int now = node.getIndex();
			int dist = node.getDistance();			
			System.out.println("now : " + now + "dist : " + dist);
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
		
		int max = 0;
		for(int dis : d) {
			System.out.println(dis);
			if(dis != maxDistance) {
				max = Math.max(max, dis);
			}
		}
		
		System.out.println(max);
	}
	
	

}
