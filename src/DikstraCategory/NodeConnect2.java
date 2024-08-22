package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//backjoon 14284
public class NodeConnect2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        int[] dt = new int[n + 1];
        Arrays.fill(dt, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.valueOf(st.nextToken()), t = Integer.valueOf(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{s, 0});
        dt[s] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowDt = now[1];

            if (nowDt > dt[nowNode]) {
                continue;
            }

            for (int i = 0; i < graph.get(nowNode).size(); i++) {
                int nextNode = graph.get(nowNode).get(i)[0];
                int nextDt = graph.get(nowNode).get(i)[1] + nowDt;

                if (dt[nextNode] > nextDt) {
                    dt[nextNode] = nextDt;
                    pq.offer(new int[]{nextNode, nextDt});
                }
            }
        }

        System.out.println(dt[t]);

    }
}
