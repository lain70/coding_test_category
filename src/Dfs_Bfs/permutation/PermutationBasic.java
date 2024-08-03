package Dfs_Bfs.permutation;

import java.util.ArrayList;
import java.util.Arrays;

//중복 불가
public class PermutationBasic {
    static ArrayList<int[]> resultList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 3;
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        permutation(arr, new int[r], visited, 0, r);

        for(int[] result : resultList){
            for(int rt : result){
                System.out.print(rt + " ");
            }
            System.out.println("");
        }
    }

    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            int[] resultOut = Arrays.copyOf(out, r);
            resultList.add(resultOut);
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
