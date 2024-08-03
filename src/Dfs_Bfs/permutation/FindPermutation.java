package Dfs_Bfs.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindPermutation {
    static int cnt;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        while ((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            cnt = 0;
            char[] arr = st.nextToken().toCharArray();
            boolean[] visited = new boolean[arr.length];
            target = Integer.valueOf(st.nextToken());
            Arrays.fill(visited, false);
            permutation(arr, new char[arr.length], visited, 0, arr.length);
            if(cnt < target){
                System.out.println(resultStr(new String(arr), target, "No permutation"));
            }
        }
    }

    static void permutation(char[] arr, char[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            cnt++;
            if(cnt == target){
                System.out.println(resultStr(new String(arr), target, new String(out)));
            }
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static String resultStr(String str1, int str2, String str3){
        return str1 + " " + str2 + " = " + str3;
    }
}
