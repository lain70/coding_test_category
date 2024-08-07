package Graph.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ConnectNetwork {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine()), m = Integer.valueOf(br.readLine()), sum = 0;
        parents = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            parents[i] = i;
        }

        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            pq.offer(new int[]{a, b, cost});
        }

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int a = now[0];
            int b = now[1];
            int cost = now[2];

            if(findP(a) != findP(b)){
                unionP(a, b);
                sum += cost;
            }
        }
        System.out.println(sum);
    }

    static int findP(int a){
        if(parents[a] == a) return a;
        return findP(parents[a]);
    }

    static void unionP(int a, int b){
        a = findP(a);
        b = findP(b);

        if(a < b){
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }
}
