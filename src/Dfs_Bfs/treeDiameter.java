package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 1967
// 어짜피 dept 마지막만 길이 알아보면 됨
// 마지막 dpat 노드에서 다른 마지막 dpth 노드를 만나면 길이 큰거 저장
public class treeDiameter {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dp;
    static boolean[] lastDepth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        lastDepth = new boolean[n + 1];
        dp = new int[n + 1];

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
            lastDepth[i] = true;
            dp[i] = 0;
        }

        StringTokenizer st;
        for(int i = 0; i < n -1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());

            graph.get(a).add(new int[]{b, cost});
            graph.get(b).add(new int[]{a, cost});

            lastDepth[a] = false;
        }

        int result = 0;
        for(int i = 1; i <= n; i++){
            if(lastDepth[i]){
                visited = new boolean[n + 1];
                dfs(i, i, 0);
                result = Math.max(result, dp[i]);
            }
        }
        System.out.println(result);
    }

    static void dfs(int start, int now, int cost){
        visited[now] = true;

        for(int i = 0; i < graph.get(now).size(); i++){

            int[] next = graph.get(now).get(i);
            int nextIdx = next[0];
            int nextCost = next[1];

            if(visited[nextIdx] != true){
                dp[start] = Math.max(dp[start], cost + nextCost);
                dfs(start, nextIdx, cost + nextCost);
            }
        }
    }
}
