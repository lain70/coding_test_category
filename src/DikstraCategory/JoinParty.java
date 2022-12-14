package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JoinParty {
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] time = new int[n+1];
        Arrays.fill(time, 101);

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            list.add(new ArrayList<int[]>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b,c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1],b[1]);
            }
        });

        pq.offer(new int[]{target,0});
        time[target] = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int nowIdx = now[0];
            int nowTime = now[1];

            if(time[nowIdx] < nowTime){
                continue;
            }

            for(int i = 0; i < list.get(nowIdx).size(); i++){
                int[] next = list.get(nowIdx).get(i);
                int cost = time[nowIdx] + next[1];
                if(cost < time[next[0]]){
                    time[next[0]] = cost;
                    pq.offer(new int[]{next[0],  cost});
                }
            }
        }

        int result = 0;
        for(int i = 1 ; i < n+1; i++){
            System.out.println(time[i]);
            if(time[i] != 101){
            result = Math.max(result, time[i]);
            }
        }

        System.out.println(result*2);

    }
}
