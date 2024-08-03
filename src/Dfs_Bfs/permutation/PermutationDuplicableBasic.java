package Dfs_Bfs.permutation;

import java.util.ArrayList;
import java.util.Arrays;

//중복 불가
public class PermutationDuplicableBasic {
    static ArrayList<int[]> resultList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 3;
        permutation(arr, new int[r], 0, r);

        for(int[] result : resultList){
            for(int rt : result){
                System.out.print(rt + " ");
            }
            System.out.println("");
        }
    }

    public static void permutation(int[] arr, int[] out, int depth, int r){
        if(depth == r){
            int[] resultOut = Arrays.copyOf(out, r);
            resultList.add(resultOut);
            return;
        }

        for(int i = 0; i < arr.length; i++){
            out[depth] = arr[i];
            permutation(arr, out, depth + 1, r);
        }
    }
}
