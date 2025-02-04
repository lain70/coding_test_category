package Implementation;

import java.io.*;
import java.util.StringTokenizer;

// backjoon 2563
public class ColorPaperExtent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[][] paper = new int[101][101];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            for(int j = a; j < a + 10; j++){
                for(int k = b; k < b + 10; k++){
                    paper[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(paper[i][j] == 1) cnt++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
