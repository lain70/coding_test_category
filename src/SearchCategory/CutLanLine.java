package SearchCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1654
public class CutLanLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lan = new int[k];
        int max = 0;
        for(int i = 0; i < k; i++){
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        if(n == 1){
            System.out.println(max);
            return;
        }

        long start = 1;
        long end = max;
        long result = 0;
        while (start <= end){
            long mid = (start + end) / 2;

            int cnt = 0;
            for(int l : lan){
                cnt += (l / mid);
            }
            if(cnt >= n){
                result = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        System.out.println(result);
    }

}
