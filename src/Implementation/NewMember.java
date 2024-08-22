package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewMember {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        int[] result = new int[t];
        StringTokenizer st;
        for(int i = 0; i < t; i++){
            int n = Integer.valueOf(br.readLine());
            int[][] arr = new int[n][2];
            for(int j = 0; j< n; j++){
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.valueOf(st.nextToken());
                arr[j][1] = Integer.valueOf(st.nextToken());
            }
            result[i] = findNewMember(arr);
        }

        for (int re : result) {
            System.out.println(re);
        }
    }

    static int findNewMember(int[][] arr){
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int cnt = 1;
        int min = arr[0][1];
        for(int i = 1; i < arr.length; i++){
            if(arr[i][1] < min){
                cnt++;
                min = arr[i][1];
            }
        }

        return cnt;
    }
}
