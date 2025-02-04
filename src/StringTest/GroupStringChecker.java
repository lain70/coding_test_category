package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GroupStringChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            cnt += findGroup(now);
        }

        System.out.println(cnt);

    }

    static int findGroup(String str){
        if(str.length() == 1){
            return 1;
        }

        boolean[] dp = new boolean[26];
        Arrays.fill(dp, false);
        for(int i = 1; i < str.length(); i++){
            if(dp[((int)str.charAt(i) - 97)]){
                return 0;
            }

            if(str.charAt(i-1) != str.charAt(i)){
                dp[((int)str.charAt(i-1) - 97)] = true;
            }
        }

        return 1;
    }
}