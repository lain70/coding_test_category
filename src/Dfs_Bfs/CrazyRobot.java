package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1405
 * 최대 14이므로 28 * 28 가운데서 시작하면 됨
 */
public class CrazyRobot {
    static boolean[] moveYn = new boolean[4];
    static int[] mX = {1, -1, 0, 0};
    static int[] mY = {0, 0, -1, 1};
    static int moveCnt;
    static double failCnt;
    static boolean[][] map = new boolean[28][28];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        moveCnt = Integer.valueOf(st.nextToken());
        for (int i = 0; i < 4; i++) {
            int move = Integer.valueOf(st.nextToken());
            if (move > 0) {
                moveYn[i] = true;
            }
        }
    }

    static void dfs(int x, int y, int depth) {

    }
}
