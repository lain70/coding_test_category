package Dfs_Bfs;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 2146 다리 만들기
// dfs 100 이하의 수 쵀대 횟수 10000 모든 경우의 수 구할 것
// 우선 같은 대륙은 같은 숫자로 구분하고 낮은 숫자의 대륙부터 높은 숫자의 대륙으로만 연결되는 다리의 값을 구한다.
public class BuildShortBridge {
    public static int result = 10001;
    public static int[] mX = new int[]{1,-1,0,0};
    public static int[] mY = new int[]{0,0,-1,1};

    public static int n = 0;
    public static int map[][];
    public static void findLand(int x, int y, int idx){

        map[x][y] = idx;

        for(int i = 0; i < 4; i++){
            int nX = x + mX[i];
            int nY = y + mY[i];

            if(nX < 0 || nX >= n || nY < 0 || nY >= n){
                continue;
            }

            if(map[nX][nY] == 1){
                findLand(nX, nY, idx);
            }
        }
    }
    public static void bfs(boolean[][] visited, int a, int b){
        int tempLand = map[a][b];
        visited[a][b] = true;
        Queue<Pointer> que = new LinkedList<>();
        que.offer(new Pointer(a,b,0));
        while (!que.isEmpty()){
            Pointer po = que.poll();
            int x = po.getX();
            int y = po.getY();
            int cnt = po.getCnt();

            for(int i = 0; i < 4; i++){
                int nX = x + mX[i];
                int nY = y + mY[i];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n || visited[nX][nY] || map[nX][nY] == tempLand){
                    continue;
                }
                visited[nX][nY] = true;

                //다른 육지 도달한 경우 다리의 길이가 현재 최소길이의 다리와 비교
                if(map[nX][nY] != 0){
                    result = Math.min(result, cnt);
                    continue;
                }

                //바다인 경우 방문 처리 후 다시 탐색
                if(map[nX][nY] == 0){
                    que.offer(new Pointer(nX, nY, cnt + 1));
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        if(n == 1){
            System.out.println(0);
            return;
        }
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        //육지를 식별한다.
        int idx = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    findLand(i, j, idx);
                    idx++;
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] > 1){
                    for(boolean[] v : visited) {
                        Arrays.fill(v, false);
                    }
                    bfs(visited, i, j);
                }
            }
        }

        System.out.println(result);
    }

    static class Pointer{
        int x;
        int y;
        int cnt;

        public Pointer(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}
