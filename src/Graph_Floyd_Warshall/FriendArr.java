package Graph_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FriendArr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < input.length; j++){
                if (input[j] == 'Y') {
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 2501;
                }
            }
        }

        for(int k = 0; k < n; k++){
            for(int a = 0; a < n; a++){
                for(int b = 0; b < n; b++){
                    if(a == b) continue;
                    if (arr[a][b] > arr[a][k] + arr[k][b]) {
                        arr[a][b] = arr[a][k] + arr[k][b];
                    }
                }
            }
        }

        int[] cnt = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 || arr[j][i] == 2){
                    cnt[i]++;
                }
            }
        }

        int max = 0;
        for(int r : cnt){
            max = Math.max(max, r);
        }

        //자기 자신 제
        System.out.println(max);
    }
}
