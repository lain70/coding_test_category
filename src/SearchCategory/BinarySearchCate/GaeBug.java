package SearchCategory.BinarySearchCate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 3020
public class GaeBug {
    static int n, h;
    static int[] up, down;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        h = Integer.valueOf(st.nextToken());

        up = new int[n / 2];
        down = new int[n / 2];

        for(int i = 0 ; i < n/2; i++){
            up[i] = Integer.valueOf(br.readLine());
            down[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = n;
        int cnt = 0;
        for(int i = 1; i < h + 1; i++){
            int wall = bSearch(0, n/2, i, down) + bSearch(0, n/2, h - i + 1, up);

            if(min == wall){
                cnt++;
                continue;
            }
            if(min > wall){
                min = wall;
                cnt = 1;
            }
        }
        System.out.println(min + " " + cnt);
    }

    static int bSearch(int start, int end, int h, int[] arr){
        while (start < end){
            int mid = (start + end) / 2;

            if(arr[mid] >= h){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return arr.length - end;
    }

    static int cntStone(int mid, int[] arr){
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > mid){
                cnt++;
            }
        }
        return cnt;
    }
}
