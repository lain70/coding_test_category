package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MakeIce {
    public static int[] mX = {1,-1,0,0};
    public static int[] mY = {0,0,-1,1};
    public static int[][] graph;
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        graph = new int[n][m];
        for(int i = 0; i < n; i++){
            graph[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 0){
                    if(dfs(i, j)){
                     cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean dfs(int x, int y){
        if((x < 0 || x >= graph.length) || (y < 0 || y >= graph[0].length)) {
            return false;
        }

        if(graph[x][y] == 0){
            graph[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nextX = x + mX[i];
                int nextY = y + mY[i];
                dfs(nextX, nextY);
            }
            return true;
        }
        return false;
    }
}
