package Greed_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProjectSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] indegree = new int[26];
        int[] dp = new int[26];
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            graph.add(new ArrayList<>());
        }

        Queue<int[]> que = new LinkedList<>();
        String inputLine;
        while(!(inputLine = br.readLine()).equals("")){
            if("".equals(inputLine)){
                break;
            }
            String[] input = inputLine.split(" ");
            int a = charToInt(input[0].charAt(0));
            int b = Integer.valueOf(input[1]);
            dp[a] = b;

            if(input.length == 2){
                dp[a] = b;
                que.offer(new int[]{a, b});
                continue;
            }

            if (input.length > 2) {
                String c = input[2];
                for(int i =0; i < c.length(); i++){
                    int d = charToInt(c.charAt(i));
                    indegree[a]++;
                    graph.get(d).add(new int[]{a, b});
                }
            }
        }

        while (!que.isEmpty()){
            int[] now = que.poll();
            int nowIdx = now[0];
            int nowD = now[1];

            for (int i = 0; i < graph.get(nowIdx).size(); i++) {
                int[] next = graph.get(nowIdx).get(i);
                int nextIdx = next[0];
                int nextD = next[1] + nowD;
                if(dp[nextIdx] < nextD){
                    dp[nextIdx] = nextD;
                }
                indegree[nextIdx]--;
                if(indegree[nextIdx] == 0){
                    que.offer(new int[]{nextIdx, nextD});
                }
            }
        }

        int max = 0;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    static int charToInt(char ch){
        return (int)ch - 65;
    }
}