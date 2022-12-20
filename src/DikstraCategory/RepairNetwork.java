package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RepairNetwork {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //최소 네트워크 속도
        int[] dp = new int[n+1];
        //현재 컴퓨터와 연결된 컴퓨터의 번호
        int[] line = new int[n+1];
        Arrays.fill(dp, n*11);

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            list.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        dp[1] = 0;
        line[1] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            int idx = now.getIdx();
            int distance = now.getDistance();
            if(dp[idx] < distance){
                continue;
            }
            for(int i = 0; i < list.get(idx).size(); i++){
                int nextIdx = list.get(idx).get(i).getIdx();
                int nextDistance = list.get(idx).get(i).getDistance() + distance;
                if(dp[nextIdx] > nextDistance){
                    dp[nextIdx] = nextDistance;
                    //다음 연결이 현재 최소일 때 이전 컴퓨터 기록
                    line[nextIdx] = idx;
                    pq.offer(new Node(nextIdx, nextDistance));
                }
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < n + 1; i++){
            if(line[i] > 0){
                sb.append(i + " " + line[i] + "\n");
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
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
}
