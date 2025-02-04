package TopologySort;

import java.io.*;
import java.util.*;

public class SortLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        int[] indegree;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        indegree = new int[n+1];
        Arrays.fill(indegree, 0);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i ++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            list.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }


        ArrayList<Integer> resultList = new ArrayList<>();
        while (!que.isEmpty()){
            int now = que.poll();
            resultList.add(now);

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int result : resultList) {
            bw.write(String.valueOf(result) + " ");
        }
        bw.flush();
        bw.close();
    }
}
/*
4 2
4 2
3 1
 */