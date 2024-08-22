package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 2437
public class Scale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 1;
        for(int i = 0; i < arr.length; i++){
            if(sum < arr[i]) {
                break;
            }
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
