package Dfs_Bfs.Combination;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationDuplicableBasic {
    static ArrayList<String> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 3;
        combination(arr, new int[r],0, 0, r);

        for(String result : resultList){
            System.out.println(result);
        }
    }

    static void combination(int[] arr, int[] out, int start, int depth, int r){
        if(depth == r){
            StringBuilder sb = new StringBuilder();
            for(int ot : out) {
                sb.append(ot + " ");
            }
            resultList.add(sb.toString());
            return;
        }

        for(int i = start; i < arr.length; i++){
            out[depth] = arr[i];
            combination(arr, out, i, depth + 1, r);
        }
    }
}
