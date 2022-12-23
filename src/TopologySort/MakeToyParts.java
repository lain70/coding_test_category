package TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeToyParts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] indegree = new int[n+1];
        Arrays.fill(indegree, 0);
        int[] needs = new int[n+1];
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            list.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            indegree[a]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a ->a[0]));
        pq.offer(new int[]{n,1});
        needs[n] = 1;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int p = now[0];
            int cost = now[1];
            for(int i = 0 ; i < list.get(p).size(); i++){
                int[] next = list.get(p).get(i);
                int sub = next[0];
                int subCost = next[1];
                if(indegree[sub] > 0){
                    needs[sub] += cost * subCost;
                    pq.offer(next);
                }else{
                    needs[sub] = needs[p]*subCost;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++){
            if(indegree[i] == 0){
                sb.append(i + " " + needs[i] + "\n");
            }
        }

        System.out.println(sb);
    }
}
