package Dfs_Bfs.permutation;

import java.io.*;
import java.util.*;

public class AllPerm {
    static int findCnt = 0, findTarget = 0;
    static String findHit = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputLine;
        StringTokenizer st;
        while((inputLine = br.readLine()) != null){
            if("".equals(inputLine)){
                break;
            }

            st = new StringTokenizer(inputLine);

            char[] perVal = st.nextToken().toCharArray();
            int target = Integer.valueOf(st.nextToken());
            findCnt = 0;
            findTarget = target;
            findHit = "";
            boolean[] visited = new boolean[perVal.length];
            perm(perVal, visited, 0, new char[perVal.length]);
            bw.write(inputLine + " = " + ("".equals(findHit)?"No permutation":findHit));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void perm(char[] arr, boolean[] visited, int depth, char[] result){
        if(arr.length == depth){
            findCnt++;
            if(findCnt == findTarget){
                findHit = new String(result);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                perm(arr, visited, depth + 1, result);
                visited[i] = false;
            }
        }
    }
}
/*
235 4
bein 20
123456 700
mnpqr 130
tuvwxyz 4000

예제 출력 1
235 4 = 352
bein 20 = nbie
123456 700 = 651342
mnpqr 130 = No permutation
tuvwxyz 4000 = ywuxvzt
 */