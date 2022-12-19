package SortCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000002];

        int min = 1000001;
        int max = -1000001;
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(br.readLine())+ 1000000;
            arr[now] = true;
            min = Math.min(min, now);
            max = Math.max(max, now);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = min; i < max+1; i++){
            if(arr[i]){
                sb.append((i - 1000000) + "\n");
                cnt++;
            }

            if(cnt == n){
                break;
            }
        }
        System.out.println(sb);
    }
}
