package Greed;

import java.io.*;
import java.util.StringTokenizer;

// backjoon 19941
public class EatHamburger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), k = Integer.valueOf(st.nextToken());
        String table = br.readLine();
        char[] arr = table.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'P'){
                int start = i - k < 0 ? 0: i - k;
                int end = i + k >= n - 1 ? n - 1 : i + k;
                for(int j = start; j <= end; j++){
                    if(arr[j] == 'H'){
                        arr[j] = 'X';
                        break;
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 'X') {
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
