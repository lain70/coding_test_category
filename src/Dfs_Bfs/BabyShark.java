package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 16236
public class BabyShark {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean hasFish = false;

        int x = 0;
        int y = 0;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            int j = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    map[i][j] = 0; x = i; y = j; j++; continue;
                }
                if(map[i][j] > 0){
                    hasFish = true;
                }
                j++;
            }
        }

        if (!hasFish) {
            System.out.println(0);
            return;
        }

        int result = 0;

        //위쪽이면서 왼쪽 먼저 방문하게 순서 설정
        int[] mx = {-1, 0, 1, 0};
        int[] my = {0, -1, 0, 1};
        int sharkSize = 2;
        int eatCnt = 0;
        boolean[][] visited;
        Queue<int[]> que = new LinkedList<>();
        //먹을 수 있는 물고기가 여러마리인 경우 우선순위 자동 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]){
                    if(o1[0] == o2[0]){
                        return Integer.compare(o1[1], o2[1]);
                    }else {
                        return Integer.compare(o1[0], o2[0]);
                    }
                }else {
                    return Integer.compare(o1[2], o2[2]);
                }
            }
        });

        boolean eatBool = true; //먹을게 있었는지 체크 더이상 먹을게 없으면 끝난다.
        while (eatBool) {
            eatBool = false;
            que.offer(new int[]{x, y, 0});
            visited = new boolean[n][n];
            visited[x][y] = true;
            int distance = n * n;//다음 물고기를 먹기 위한 최소거리
            while (!que.isEmpty()) {
                int[] now = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + mx[i];
                    int ny = now[1] + my[i];
                    int move = now[2];

                    // 작은 물고기를 먹을 수 있는 최소 거리보다 커진 경우
                    if (move > distance) {
                        break;
                    }

                    //map을 벗어났거나, 방문했거나, 현재 상어 크기보다 큰 물고기가 있는 경우
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || sharkSize < map[nx][ny]) {
                        continue;
                    }


                    // 방문 하지 않았고 map이 고기가 없는 경우 0 또는 물고기 크기가 같은 경우
                    if (visited[nx][ny] != true && (0 == map[nx][ny] || sharkSize == map[nx][ny])) {
                        //방문처리
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny, move + 1});
                        continue;
                    }

                    //상어 크기보다 작은 경우
                    if (map[nx][ny] < sharkSize && move + 1 <= distance) {
                        distance = Math.min(distance, move + 1);
                        pq.offer(new int[]{nx, ny, move + 1});
                        eatBool = true;

                    }
                }

                //먹을 수 있는 물고기가 여러 마리인 경우 우선순위 정하기
                if (eatBool) {
                    while (!pq.isEmpty()){
                        int[] test = pq.peek();
                        System.out.println("x : " + test[0] + " / y : " + test[1] + " / move : " + test[2]);
                    }
                    int[] eatFish = pq.peek();

                    int lastX = eatFish[0];
                    int lastY = eatFish[1];
                    int lastMove = eatFish[2];
//                    System.out.println("lastX : " +lastMove + "/ lastY : " + lastY + " / lastMove : " + lastMove);
                    //물고기 먹은 자리는 0으로
                    map[lastX][lastY] = 0;
                    //상어가 먹은 위치
                    x = lastX;
                    y = lastY;

                    //먹은 고기의 갯수 증가
                    eatCnt++;
                    //먹은 고기의 갯수와 상어의 크기가 같으면 상어 성장
                    if (sharkSize == eatCnt) {
                        sharkSize++;
                        eatCnt = 0;
                    }
                    que.clear();
                    pq.clear();
                    //이동거리 추가
                    result += lastMove;
                    eatBool = false;
                }
            }
        }
        System.out.println(result);

    }
}
