package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VocaStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[26];
        char[] arr = s.toLowerCase().toCharArray();

        int max = 0;
        int idx = 0;
        for(char ar : arr){
            int now = ar - 'a';
            cnt[now]++;
            if(cnt[now] > max){
                max = cnt[now];
                idx = now;
            }
        }

        Arrays.sort(cnt);

        if (cnt[24] == max) {
            System.out.println("?");
        }else {
            String result = String.valueOf((char) ('a' + idx)).toUpperCase();
            System.out.println(result);
        }
    }
}
