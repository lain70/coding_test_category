package DikstraCategory;

import java.util.*;

public class SNender {
    static class Node3 implements Comparable<Node3> {

        int node;
        int distance;

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Node3(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node3 o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int start = input[2];

        ArrayList<ArrayList<Node3>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node3>());
        }

        for(int i = 0; i < m; i++){
            int[] input2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(input2[0]).add(new Node3(input2[1], input2[2]));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, 200001);

        PriorityQueue<Node3> pq = new PriorityQueue<>();
        pq.offer(new Node3(start,0));
        distance[start] = 0;
        while (!pq.isEmpty()){
            Node3 temp = pq.poll();
            if(distance[temp.node] < temp.distance){
                continue;
            }else{
                for(int i = 0; i < graph.get(temp.node).size(); i++){
                    int cost = graph.get(temp.node).get(i).distance;

                    if(cost < distance[graph.get(temp.node).get(i).node]){
                        distance[graph.get(temp.node).get(i).node] = cost;
                        pq.offer(new Node3(graph.get(temp.node).get(i).node, cost));
                    }
                }
            }
        }

        int cnt = 0;
        int maxTime = 0;
        for(int d : distance){
            if(d != 0 && d != 200001){
                cnt++;
                maxTime = Math.max(maxTime, d);
            }
        }

        System.out.println(cnt + " " + maxTime);

    }
}
