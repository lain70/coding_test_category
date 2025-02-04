 package TopologySort;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WorkingTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int[] totalTimes = new int[n + 1];
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[0] - b[0];});
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.valueOf(st.nextToken());
            int workTime = Integer.valueOf(st.nextToken());

            pq.offer(new int[]{level, i, workTime});

            list.get(level).add(new int[]{i, workTime});
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int nowLevel = now[0];
            int nowCom = now[1];
            int nowWorkTime = now[2];

            if(nowLevel == 1){
                totalTimes[nowCom] = nowWorkTime;
            }

            for (int i = 0; i < list.get(nowLevel + 1).size(); i++) {
                int[] next = list.get(nowLevel + 1).get(i);
                int nextCom = next[0];
                int nextWorkTime = next[1];

                int nextTotalTime = (int) (Math.pow(Double.valueOf(nowCom - nextCom), 2) + totalTimes[nowCom] + nextWorkTime);
                totalTimes[nextCom] = Math.max(totalTimes[nextCom], nextTotalTime);
            }
        }

        int max = 0;
        for (int next : totalTimes) {
            max = Math.max(max, next);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
/*
9
1 1
3 9
3 1
4 2
4 2
2 5
1 30
4 2
5 3
 */