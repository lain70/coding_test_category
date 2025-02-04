package Dfs_Bfs.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutation {
    static int n;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++){
            arr[i - 1] = i;
        }

        boolean[] visited = new boolean[n];
        perm(arr, new int[n], visited, 0, n);

        for(int[] re : list){
            for(int r : re){
                System.out.print(r + " ");
            }
            System.out.println("");
        }
    }

    static void perm(int[] in, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            int[] result = Arrays.copyOf(out, out.length);
            list.add(result);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = in[i];
                perm(in, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }

    }
}
