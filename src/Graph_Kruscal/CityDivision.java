package Graph_Kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CityDivision {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i = 1; i < n+1; i++){
            parents[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{a, b, cost});
        }

        int costSum = 0;
        int maxCost = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int a = now[0];
            int b = now[1];
            int cost = now[2];

            if(find(a) != find(b)){
                union(a,b);
                costSum += cost;
                maxCost = cost;
            }
        }

        System.out.println(costSum - maxCost);

    }

    static int find(int a){
        if(parents[a] == a) return a;
        return find(parents[a]);
    }

    static void union(int a, int b){
        int ap = find(a);
        int bp = find(b);

        if(ap < bp){
            parents[bp] = ap;
        }else{
            parents[ap] = bp;
        }
    }
}
