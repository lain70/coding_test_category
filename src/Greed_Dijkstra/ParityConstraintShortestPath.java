package Greed_Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ParityConstraintShortestPath {
    static int v, e, k;
    static ArrayList<ArrayList<int[]>> nodeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.valueOf(st.nextToken());
        e = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.valueOf(st.nextToken());

        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= v; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int dt = Integer.valueOf(st.nextToken());
            nodeList.get(a).add(new int[]{b, dt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[1] - b[1];});
        distance[k] = 0;
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowIdx = now[0];
            int nowDt = now[1];

            if(distance[nowIdx] < nowDt) continue;

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

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= v; i++){
            bw.write(distance[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(distance[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */