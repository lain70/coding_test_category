package DynamicProgram.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//backjoon 18438
public class Lcs5 {
    static int[][] dp;
    static char[] str1;
    static char[] str2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new int[str1.length + 1][str2.length + 1];

        for(int i = 1; i <= str1.length; i++){
            for(int j = 1; j <= str2.length; j++){
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        String result = "";

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{str1.length, str2.length});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];

            if(x < 1 || y < 1){
                continue;
            }

            if(str1[x - 1] == str2[y - 1]) {
                result = str1[x - 1] + result;
                que.offer(new int[]{x - 1, y - 1});
            }else if(dp[x][y - 1] >= dp[x - 1][y]) {
                que.offer(new int[]{x, y - 1});
            } else {
                que.offer(new int[]{x - 1, y});
            }

        }

        System.out.println(result.length());
        System.out.println(result);
    }
}
