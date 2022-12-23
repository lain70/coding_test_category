package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1507 궁금한 민호
public class QuestionMinho {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        boolean[][] change = new boolean[n][n];

        for(int i = 0 ; i<n; i++){
            int j = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()){
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int a = 0; a < n; a++){
            for(int b = 0; b < n; b++){
                for(int k = 0; k < n; k++){
                    if(a == k || k == b|| b == a) {
                        continue;
                    }
                    if(map[a][b] > map[a][k] + map[k][b]) {
                        System.out.println(-1);
                        return;
                    }

                    if(map[a][b] == map[a][k] + map[k][b]) {
                        change[a][b] = true;
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }

                if(change[i][j] != true) {
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer/2);
    }
}
