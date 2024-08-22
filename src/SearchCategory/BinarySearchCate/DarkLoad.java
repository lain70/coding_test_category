package SearchCategory.BinarySearchCate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// backjun 17266
public class DarkLoad {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        m = Integer.valueOf(br.readLine());
        arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int result = bSearch(n);

        System.out.println(result);
    }

    static int bSearch(int end){
        int start = 0, mid = 0;
        while (start < end){
            mid = (start + end) / 2;
            //거리의 빛의 합이 n보다 작으면
            if (!sumLight(mid)) {
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        return start;
    }

    //거리를 빛추는 길이
    static boolean sumLight(int h){
        if(arr[0] - h > 0){
            return false;
        }

        if(arr[arr.length - 1] + h < n){
            return  false;
        }

        for(int i = arr.length - 1; i > 0; i--){
            int distance = arr[i] - arr[i-1];
            if(distance > h * 2){
                return false;
            }
        }

        return true;
    }
}
