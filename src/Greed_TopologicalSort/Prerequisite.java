package Greed_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prerequisite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        int[] indegree = new int[n + 1];
        int[] season = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
            season[i] = 1;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        while (!que.isEmpty()){
            int now = que.poll();

            for(int i = 0; i < graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                indegree[next]--;
                season[next] = Math.max(season[next], season[now] + 1);
                if(indegree[next] == 0){
                    que.offer(next);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.print(season[i] + " ");
        }
    }
}
