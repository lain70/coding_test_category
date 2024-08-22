package SortCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.valueOf(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int aIdx = 0;
        int bIdx = 0;
        while (aIdx < n && bIdx < m){
            if(a[aIdx] <= b[bIdx]){
                sb.append(a[aIdx++] + " ");
            }else{
                sb.append(b[bIdx++] + " ");
            }
        }

        if(aIdx == n){
            for(int k = bIdx; k < m; k++){
                sb.append(b[k] + " ");
            }
        }else{
            for(int k = aIdx; k < n; k++){
                sb.append(a[k] + " ");
            }
        }

        System.out.print(sb);
    }
}
