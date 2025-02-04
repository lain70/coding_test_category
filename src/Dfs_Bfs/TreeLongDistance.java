package Dfs_Bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeLongDistance {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int n;
    static int maxSum = 0, maxNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            while (st.hasMoreTokens()){
                int b = Integer.valueOf(st.nextToken());
                if(b != -1){
                    int c = Integer.valueOf(st.nextToken());
                    graph.get(a).add(new int[]{b, c});
                }
            }
        }

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        dfs(visited, 1, 0);

        Arrays.fill(visited, false);
        dfs(visited, maxNode, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
    }

    static void dfs(boolean[] visited, int start, int sum){
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++){
            int[] next = graph.get(start).get(i);
            int a = next[0];
            if(!visited[a]){
                int b = next[1];
                dfs(visited, a, sum + b);
            }
        }

        if(maxSum < sum){
            maxSum = sum;
            maxNode = start;
        }
    }
}