package DynamicProgram.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 13711 -> LIS 문제다. . .다음에 풀자
public class Lcs4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr2[i] = st.nextToken();
        }
    }
}
