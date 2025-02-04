package TopologySort;

import java.io.*;
import java.util.*;

public class QustionPaper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        int[] indegree = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            indegree[i] = 0;
            visited[i] = false;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> {return a-b;});

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0 && !visited[i]) {
                que.offer(i);
            }
        }


        while (!que.isEmpty()){
            int now = que.poll();
            resultList.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                indegree[next]--;
                if (indegree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int re : resultList) {
            bw.write(String.valueOf(re) + " ");
        }

        bw.flush();
        bw.close();
    }
}
