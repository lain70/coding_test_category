package Dfs_Bfs.Combination;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationBasic {
    static ArrayList<String> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 3;
        boolean[] visited = new boolean[arr.length];

        Arrays.stream(arr).max().orElse(0);
        Arrays.fill(visited, false);
        combination(arr, visited,0, 0, r);

        for(String result : resultList){
            System.out.println(result);
        }
    }

    static void combination(int[] arr, boolean visited[], int start, int depth, int r){
        if(depth == r){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                if(visited[i]){
                    sb.append(arr[i] + " ");
                }
            }
            resultList.add(sb.toString());
            return;
        }

        for(int i = start; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }
}
