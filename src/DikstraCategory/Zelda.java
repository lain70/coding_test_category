package DikstraCategory;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Zelda {
    static int[] nX = new int[]{1, -1, 0, 0};
    static int[] nY = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt = 1;
        while (true){
            int n = Integer.valueOf(br.readLine());
            if(n == 0){
                break;
            }

            int[][] cost = new int[n][n];
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], 125*125);
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            int sum = bfs(cost, map);
            bw.write("Problem " + cnt + ": " + String.valueOf(sum));
            bw.newLine();
            cnt++;
        }
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] cost, int[][] map){
        int costSum = 0;
        cost[0][0] = map[0][0];
        // 0 = x, 1 = y, 2 = cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, map[0][0]});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCost = now[2];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + nX[i];
                int nextY = nowY + nY[i];
                if(nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map.length){
                    if (cost[nextX][nextY] > map[nextX][nextY] + nowCost) {
                        cost[nextX][nextY] = map[nextX][nextY] + nowCost;
                        pq.offer(new int[]{nextX, nextY, cost[nextX][nextY]});
                    }
                }
            }
        }

        return cost[map.length - 1][map.length - 1];
    }
}
