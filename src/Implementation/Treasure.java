package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1026
public class Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr2[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, (a, b) -> b - a);

        int result = 0;
        for(int i = 0; i < n; i++){
            result += arr1[i] * arr2[i];
        }

        System.out.println(result);
    }
}
