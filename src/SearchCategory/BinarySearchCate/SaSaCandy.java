package SearchCategory.BinarySearchCate;

import java.io.*;
import java.util.StringTokenizer;

// backjoon 27968
public class SaSaCandy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        long[] arr = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if(i == 0){
                arr[i] = Long.valueOf(st.nextToken());
            }else{
                arr[i] = arr[i-1] + Long.valueOf(st.nextToken());
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            long b = Long.valueOf(br.readLine());
            if(b > arr[m-1]){
                bw.write("Go away!");
            }else{
                int cnt = binarySearch(arr, b) + 1;
                bw.write(String.valueOf(cnt));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static int binarySearch(long[] arr, long target){
        int start = 0, end = arr.length, mid = 0;

        while (start < end){
            mid = (start + end) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
/*
10 10
1 2 3 4 5 6 7 8 9 10
3
6
10
15
21
28
37
45
55
66
 */