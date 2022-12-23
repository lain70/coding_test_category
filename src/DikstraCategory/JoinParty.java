package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1238 파티
public class JoinParty {
    static class Node implements Comparable<Node>{
        int idx;
        int distance;

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

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
    static int n,m,target;
    static int INF = 100 * 10000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        int[] go, back;
        go = new int[n+1];
        back = new int[n+1];

        ArrayList<ArrayList<Node>> goList = new ArrayList<>();
        ArrayList<ArrayList<Node>> backList = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            goList.add(new ArrayList<Node>());
            backList.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            goList.get(a).add(new Node(b,c));
            backList.get(b).add(new Node(a,c));
        }

        // target 마을에 가는 시간 구하기
        go = dikstra(goList);
        // target 마을에서 돌아오는 시간 구하기
        back = dikstra(backList);

        int result = 0;
        for(int i = 0; i < n+1; i++){
            if(i != target && go[i] != INF && back[i] != INF){
                result = Math.max(result, (go[i] + back[i]));
            }
        }
        System.out.println(result);
    }

    static int[] dikstra(ArrayList<ArrayList<Node>> list){
        int[] d = new int[n+1];
        Arrays.fill(d, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(target,0));
        d[target] = 0;
        while (!pq.isEmpty()){
            Node now = pq.poll();
            int nowIdx = now.idx;
            int nowTime = now.distance;

            if(d[nowIdx] < nowTime){
                continue;
            }

            if(list.size() < 1){
                continue;
            }

            for(int i = 0; i < list.get(nowIdx).size(); i++){
                Node next = list.get(nowIdx).get(i);
                int cost = d[nowIdx] + next.distance;
                if(cost < d[next.idx]){
                    d[next.idx] = cost;
                    pq.offer(new Node(next.idx, cost));
                }
            }
        }

        return d;
    }
}
