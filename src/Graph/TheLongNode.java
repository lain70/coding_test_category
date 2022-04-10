package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node3 implements Comparable<Node3>{
	private int idx;
	private int distance;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Node3(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}
	@Override
	public int compareTo(Node3 o) {
		return Integer.compare(this.distance, o.distance);
	}
	
}
public class TheLongNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, 50001);
        distance[1] = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edge.length; i++) {
        	list.get(edge[i][0]).add(edge[i][1]);
        	list.get(edge[i][1]).add(edge[i][0]);
        }
        
        PriorityQueue<Node3> pq = new PriorityQueue<>();
        pq.offer(new Node3(1, 0));
        
        while(!pq.isEmpty()) {
        	Node3 now = pq.poll();
        	int nowIdx = now.getIdx();
        	int nowDistance = now.getDistance();
        	
        	for(int i = 0; i < list.get(nowIdx).size(); i++) {
        		if(distance[list.get(nowIdx).get(i)] > nowDistance + 1) {
        			distance[list.get(nowIdx).get(i)] = nowDistance + 1;
        			pq.add(new Node3(list.get(nowIdx).get(i), distance[list.get(nowIdx).get(i)]));
        		}        		
        	}
        }
        
        int max = 0;
        for(int i = 1; i < distance.length; i++) {
        	if(distance[i] < 50001) {
        		max = Math.max(max, distance[i]);
        	}
        }
        
        for(int i = 1; i < distance.length; i++) {
        	if(distance[i] == max) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
