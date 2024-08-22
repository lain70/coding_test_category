package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FastLoad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken());
        int[] distance = new int[d + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= d; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int dt = Integer.valueOf(st.nextToken());

            if(end - start < dt || end > d){
                continue;
            }

            list.get(start).add(new int[]{end, dt});
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        que.offer(new int[]{0, 0});
        while (!que.isEmpty()){
            int[] now = que.poll();
            int nowIdx = now[0];
            int nowDt = now[1];

            if(distance[nowIdx] < nowDt) {
                continue;
            }

            if(nowIdx + 1 <= d && nowDt + 1 < distance[nowIdx + 1]){
                distance[nowIdx + 1] = nowDt + 1;
                que.offer(new int[]{nowIdx + 1, nowDt + 1});
            }

            for(int i = 0; i < list.get(nowIdx).size(); i++){
                int[] next = list.get(nowIdx).get(i);
                int nextIdx = next[0];
                int nextDt = next[1] + nowDt;

                if(nextDt < distance[nextIdx]){
                    distance[nextIdx] = nextDt;
                    que.offer(new int[]{nextIdx, nextDt});
                }
            }
        }

        System.out.println(distance[d]);
    }
}
