package Greed_Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KingVisit {
    static int n, m, a, b, k, g;
    static int[] kings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = Integer.valueOf(st.nextToken());    // start
        b = Integer.valueOf(st.nextToken());    // end
        k = Integer.valueOf(st.nextToken());    // 차이
        g = Integer.valueOf(st.nextToken());    // 왕이 들리는 곳

        kings = new int[g];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < g; i++){
            kings[i] = Integer.valueOf(st.nextToken());
        }


    }
}
