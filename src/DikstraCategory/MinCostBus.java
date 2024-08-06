package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 1916
public class MinCostBus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine()), m = Integer.valueOf(br.readLine());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.valueOf(st.nextToken());
            int city2 = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            graph.get(city1).add(new int[]{city2, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken()), end = Integer.valueOf(st.nextToken());

        long[] distance = new long[n + 1];
        Arrays.fill(distance, 100000*100000);
        distance[start] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2)->Long.compare(o1.d, o2.d));
        que.offer(new Node(start,0));
        while (!que.isEmpty()){
            Node now = que.poll();
            int nowIdx = now.idx;
            long nowD = now.d;

            if(distance[nowIdx] < nowD){
                continue;
            }

            for(int i = 0; i < graph.get(nowIdx).size(); i++){
                int nextIdx = graph.get(nowIdx).get(i)[0];
                long nextD = graph.get(nowIdx).get(i)[1];
                if(distance[nextIdx] > distance[nowIdx] + nextD){
                    distance[nextIdx] = distance[nowIdx] + nextD;
                    que.offer(new Node(nextIdx, nextD));
                }
            }
        }

        System.out.println(distance[end]);
    }

    static class Node{
        int idx;
        long d;

        public Node(int idx, long d) {
            this.idx = idx;
            this.d = d;
        }
    }
}
