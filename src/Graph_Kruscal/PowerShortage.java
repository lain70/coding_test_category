package Graph_Kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PowerShortage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.valueOf(st.nextToken()), n = Integer.valueOf(st.nextToken());
        while (m != 0 || n != 0){
            int[] parents = new int[m];
            for(int i = 0; i < m; i++){
                parents[i] = i;
            }
            int allCost = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(st.nextToken());
                int b = Integer.valueOf(st.nextToken());
                int cost = Integer.valueOf(st.nextToken());

                pq.offer(new int[]{a, b, cost});
                allCost += cost;
            }

            int minCost = 0;
            while (!pq.isEmpty()){
                int[] now = pq.poll();
                int a = now[0];
                int b = now[1];

                if(findP(parents, a) != findP(parents, b)){
                    unionP(parents, a, b);
                    minCost += now[2];
                }
            }

            System.out.println(allCost - minCost);


            st = new StringTokenizer(br.readLine());
            m = Integer.valueOf(st.nextToken());
            n = Integer.valueOf(st.nextToken());
        }
    }

    static int findP(int[] parents, int a){
        if(parents[a] == a) return a;
        return parents[a] = findP(parents, parents[a]);
    }

    static void unionP(int[] parents, int a, int b){
        a = findP(parents, a);
        b = findP(parents, b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
