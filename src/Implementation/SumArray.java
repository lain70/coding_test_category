package Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class SumArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.valueOf(br.readLine());
        for (int i = 0; i < k; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken()), c = Integer.valueOf(st.nextToken()), d = Integer.valueOf(st.nextToken());
            for (int j = a; j <= c; j++) {
                for (int l = b; l <= d; l++) {
                    sum += map[j][l];
                }
            }
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
/*
2 3
1 2 4
8 16 32
3
1 1 2 3
1 2 1 2
1 3 2 3
 */