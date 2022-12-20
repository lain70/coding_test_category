package DikstraCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 1261
public class AlgoSpot {
    static class Node implements Comparable<Node> {
        int dx;
        int dy;
        int cnt;

        public int getDx() {
            return dx;
        }

        public void setDx(int dx) {
            this.dx = dx;
        }

        public int getDy() {
            return dy;
        }

        public void setDy(int dy) {
            this.dy = dy;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public Node(int dx, int dy, int cnt) {
            this.dx = dx;
            this.dy = dy;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getCnt(), o.getCnt());
        }
    }

    public static void main(String[] args) throws IOException {
        int[] mx = {-1,1,0,0};
        int[] my = {0,0,-1,1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.valueOf(input[j]);
            }
        }

        int answer = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        visited[0][0] = true;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            int nowX = now.getDx();
            int nowY = now.getDy();
            int nowCnt = now.getCnt();

            if(nowX == n - 1 && nowY == m - 1){
                answer = Math.min(answer, nowCnt);
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = nowX + mx[i];
                int ny = nowY + my[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] == true){
                    continue;
                }

                if(map[nx][ny] == 0){
                    pq.offer(new Node(nx, ny, nowCnt));
                }

                if(map[nx][ny] == 1){
                    pq.offer(new Node(nx, ny, nowCnt + 1));
                }
                visited[nx][ny] = true;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE? 0 : answer);

    }
}
