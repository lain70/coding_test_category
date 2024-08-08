package Greed_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BuildToy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine()), m = Integer.valueOf(br.readLine());

        List<int[]>[] list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        int[] baseCheck = new int[n + 1];

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());

            list[a].add(new int[]{b, cost});
            indegree[b]++;
            baseCheck[a]++;
        }

        int[] sum = new int[n + 1];
        sum[n] = 1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(n);
        while (!que.isEmpty()) {
            int now = que.poll();

            for(int i = 0; i < list[now].size(); i++){
                int[] next = list[now].get(i);
                int nA = next[0];
                int nCost = next[1];
                sum[nA] += sum[now] * nCost;
                indegree[nA]--;
                if(indegree[nA] == 0){
                    que.offer(nA);
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            if(baseCheck[i] == 0){
                System.out.println(i + " " + sum[i]);
            }
        }

    }
}
