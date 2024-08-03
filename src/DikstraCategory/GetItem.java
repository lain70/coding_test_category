package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 14938
public class GetItem {
    static class Node implements Comparable<Node>{

        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

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

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    static int n,m,r;
    static int result = 0;
    static int[] items;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int it = 1;
        while (st.hasMoreTokens()){
            items[it] = Integer.parseInt(st.nextToken());
            it++;
        }


        for(int i = 0; i < n + 1; i++){
            list.add(new ArrayList<Node>());
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a,c));
        }

        for(int i = 1; i < n + 1; i++){
            dikstra(i);
        }

        System.out.println(result);

    }

    static int INF = 15 * 100 + 1;
    // 길이가 m 이하인 경우만 기록
    static void dikstra(int site){
        int[] d = new int[n+1];
        Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        d[site] = 0;
        pq.offer(new Node(site, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            int nIdx = now.idx;
            int nDistance = now.distance;

            if(d[nIdx] < nDistance){
                continue;
            }

            for(int i = 0; i < list.get(nIdx).size(); i++){
                Node next = list.get(nIdx).get(i);
                int cost = d[nIdx] + next.distance;
                if(cost < d[next.idx]){
                    d[next.idx] = cost;
                    pq.offer(new Node(next.idx, cost));
                }
            }
        }

        int sum = 0;
        for(int i = 1; i < n + 1; i++){
            if(d[i] != INF && d[i] <= m){
                sum += items[i];
            }
        }

        result = Math.max(result, sum);
    }
}
