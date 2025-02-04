package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElectionFraud {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

    }
}
