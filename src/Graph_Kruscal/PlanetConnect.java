package Graph_Kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//backjoon 16398
public class PlanetConnect {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int cost = Integer.valueOf(st.nextToken());
                if(i != j){
                    pq.offer(new int[]{i, j, cost});
                }
            }
        }

        long allCost = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            if(findP(now[0]) != findP(now[1])){
                unionP(now[0], now[1]);
                allCost += now[2];
            }
        }

        System.out.println(allCost);
    }

    static int findP(int a){
        if(parents[a] == a) return a;
        return parents[a] = findP(parents[a]);
    }

    static void unionP(int a, int b){
        a = findP(a);
        b = findP(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}