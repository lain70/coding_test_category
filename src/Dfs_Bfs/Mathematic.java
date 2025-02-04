package Dfs_Bfs;

import java.io.*;
import java.util.*;

public class Mathematic {
    static int[] mX = {1, 0};
    static int[] mY = {0, 1};
    static int n;
    static String map[][];
    static ArrayList<Integer> resultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        map = new String[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
            }
        }

        String[] math = new String[3];
        dfs(0, 0, math, 0);
        int max = Collections.max(resultList);
        int min = Collections.min(resultList);

        StringBuilder sb = new StringBuilder(max + " " + min);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, String[] math, int cnt){
        math[cnt] = map[x][y];
        if(cnt == 2){
            String a = math[0];
            String c = math[1];
            String b = math[2];

            String answer = String.valueOf(cal(a, b, c));
            cnt = 0;
            math = new String[3];
            math[0] = answer;
        }

        if (x == n - 1 && y == n - 1) {
            int result = Integer.valueOf(math[0]);
            resultList.add(result);
        } else {
            for (int i = 0; i < 2; i++) {
                int nX = x + mX[i];
                int nY = y + mY[i];
                if(nX < n && nY < n){
                    dfs(nX, nY, math, cnt+1);
                }
            }
        }
    }

    public static int cal(String a, String b, String symbol){
        switch (symbol) {
            case "+":
                return Integer.valueOf(a) + Integer.valueOf(b);
            case "-":
                return Integer.valueOf(a) - Integer.valueOf(b);
            default:
                return Integer.valueOf(a) * Integer.valueOf(b);
        }
    }
}
/*
5
5 + 5 - 3
* 3 - 1 -
4 + 5 + 2
- 2 * 3 -
1 * 5 + 2
 */