package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

//백준 2251
public class WaterCase {
    public static int[] tong;
    public static Set<Integer> result = new TreeSet<>();
    public static boolean[][]check;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tong = new int[3];
        check = new boolean[201][201];
        for(int i = 0; i <3; i++){
            tong[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, tong[2]);

        for(Integer s : result){
            System.out.print(s + " ");
        }
    }

    public static void dfs(int a, int b, int c){
        if(check[a][b]) return;

        if(a == 0 && c != 0){
            result.add(c);
        }

        check[a][b] = true;
        //a -> b
        if((a+b) > tong[1]){
            dfs((a+b)-tong[1], tong[1], c);
        }else{
            dfs(0, a+b, c);
        }

        //b -> a
        if((a+b) > tong[0]){
            dfs(tong[0], (a+b)-tong[0], c);
        }else{
            dfs(a+b, 0, c);
        }

        // c -> a
        if((a+c) > tong[0]){
            dfs(tong[0], b, (a+c)-tong[0]);
        }else{
            dfs(a+c, b, 0);
        }

        // c -> b
        if((b+c) > tong[1]){
            dfs(a, tong[1], (b+c)-tong[1]);
        }else{
            dfs(a, b+c, 0);
        }

        // a -> c
        dfs(a, 0, b+c);

        // b -> c
        dfs(0, b,a+c);
    }
}
