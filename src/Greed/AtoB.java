package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 16953
public class AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = -1;
        int cnt = 0;
        while(a <= b){
            if(b == a){
                result = cnt + 1;
                break;
            }

            if(b % 10 == 1){
                b = b/10;
                cnt++;
            }else if(b % 2 == 0){
                b = b / 2;
                cnt++;
            }else {
                break;
            }
        }

        System.out.println(result);
    }
}
