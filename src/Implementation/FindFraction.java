package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.valueOf(br.readLine());

        int sum = 0;
        int idx = 0;
        for(int i = 1; i <= x; i++){
            sum += i;
            if(sum >= x){
                sum -= i;
                idx = i;
                break;
            }
        }

        int targetA = x - sum;
        int targetB = idx - (targetA - 1);
        StringBuilder sb = new StringBuilder();
        if(idx % 2 == 0){
            sb.append(targetA).append("/").append(targetB);
        }else{
            sb.append(targetB).append("/").append(targetA);
        }

        System.out.println(sb);
    }
}