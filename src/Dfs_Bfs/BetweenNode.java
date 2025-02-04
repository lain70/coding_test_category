package Dfs_Bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BetweenNode {
    static int minSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int distance = Integer.valueOf(st.nextToken());
            list.get(start).add(new int[]{end, distance});
            list.get(end).add(new int[]{start, distance});
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());

            minSum = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n + 1];
            dfs(start, end, 0, list, visited);
            bw.write(String.valueOf(minSum));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int node, int end, int sum, ArrayList<ArrayList<int[]>> list, boolean[] visited){
        if(node == end){
            minSum = Math.min(minSum, sum);
            return;
        }

        visited[node] = true;

        for (int j = 0; j < list.get(node).size(); j++) {
            int[] next = list.get(node).get(j);
            int nextNode = next[0];
            int nextDistance = next[1];

            if(!visited[nextNode]){
                dfs(nextNode, end, sum + nextDistance, list, visited);
            }
        }
    }
}
/*
4 2
2 1 2
4 3 2
1 4 3
1 2
3 2
 */