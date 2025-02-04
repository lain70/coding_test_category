package Greed_Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//backjoon 12834
public class WeeklyMeeting {
    static int n, v, e;
    static int a, b;
    static int[] members;
    static int[] mebersDistance;
    static ArrayList<ArrayList<int[]>> nodeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());    // 회원수
        v = Integer.valueOf(st.nextToken());    // 노드
        e = Integer.valueOf(st.nextToken());    // 간선

        int[] sumDt = new int[n];

        members = new int[n];
        for (int i = 0; i <= v; i++) {
            nodeList.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.valueOf(st.nextToken());
        b = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            members[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            int distance = Integer.valueOf(st.nextToken());
            nodeList.get(x).add(new int[]{y, distance});
            nodeList.get(y).add(new int[]{x, distance});
        }

        for (int i = 0; i < n; i++) {
            int member = members[i];
            int distanceA = dijkstra(member, a);
            int distanceB =  dijkstra(member, b);
            sumDt[i] = distanceA + distanceB;
        }

        int result = 0;
        for(int sum : sumDt){
            result += sum;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result < 0? -1 : result));
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end){
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int nowIdx = now[0];
            int nowDt = now[1];

            if(distance[nowIdx] < nowDt){
                continue;
            }

            for (int i = 0; i < nodeList.get(nowIdx).size(); i++) {
                int[] next = nodeList.get(nowIdx).get(i);
                int nextIdx = next[0];
                int nextDt = next[1] + nowDt;

                if(nextDt < distance[nextIdx]){
                    distance[nextIdx] = nextDt;
                    pq.offer(new int[]{nextIdx, nextDt});
                }
            }
        }

        return distance[end] == Integer.MAX_VALUE ? -1 : distance[end];
    }
}
/*
2 5 10
3 5
2 4
3 2 91
1 3 44
5 3 93
1 4 1
4 5 53
4 2 23
5 1 60
2 1 63
3 4 38
5 2 17
 */
