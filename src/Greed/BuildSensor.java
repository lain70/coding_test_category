package Greed;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BuildSensor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int n = Integer.valueOf(br.readLine());
        int k = Integer.valueOf(br.readLine());

        int[] sensor = new int[n];
        int[] distance = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            sensor[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(sensor);

        if(k < n){
            for(int i = 0; i < n - 1; i ++){
                distance[i] = sensor[i + 1] - sensor[i];
            }
        }

        Arrays.sort(distance);
        for(int i = 0; i < n - k; i++){
            result += distance[i];
        }

        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
