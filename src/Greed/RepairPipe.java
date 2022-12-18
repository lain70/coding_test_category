package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1449
public class RepairPipe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] pipe = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++){
            pipe[i] = Integer.valueOf(st.nextToken());
            max = Math.max(max, pipe[i]);
        }

        boolean[] checkPipe = new boolean[max + 1];

        Arrays.sort(pipe);

        int result = 0;
        for(int i = 0; i < pipe.length; i++){
            if(checkPipe[pipe[i]] != true){
                result += 1;
                int k = Math.min(pipe[i]+l, max+1);
                for(int j = pipe[i]; j < k; j++){
                    checkPipe[j] = true;
                }
            }
        }


        System.out.println(result);
    }
}
