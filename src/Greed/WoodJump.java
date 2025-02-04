package Greed;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WoodJump {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.valueOf(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.valueOf(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[j] = Integer.valueOf(st.nextToken());
            }
            bw.write(maxCompare(arr));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static String maxCompare(int[] arr){
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if (i % 2 == 0) {
                result[(i/2)] = arr[i];
            }else {
                result[arr.length - 1 - (i/2)] = arr[i];
            }
        }

        int max = 0;
        for(int i = 0; i < result.length; i++){
            if(i == result.length - 1){
                max = Math.max(max, Math.abs(result[i] - result[0]));
            }else {
                max = Math.max(max, Math.abs(result[i] - result[i + 1]));
            }
        }
        return String.valueOf(max);
    }
}
/*
3
7
13 10 12 11 10 11 12
5
2 4 5 7 9
8
6 6 6 6 6 6 6 6
 */