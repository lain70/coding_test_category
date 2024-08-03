package Dfs_Bfs.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1010 순열 갯수 구하기
public class BuildBridgeCombi {
    static int[][] dt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());
            dt = new int[31][31];
            System.out.println(combination(n,r));
        }
    }

    static int combination(int n, int r){
        if(dt[n][r] > 0){
            return dt[n][r];
        }

        if(n == r || r == 0){
            return 1;
        }

        return dt[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
