package SearchCategory.BinarySearchCate;

import java.io.*;
import java.util.StringTokenizer;

public class CampBus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, T, S, I, C;
        N = Integer.valueOf(st.nextToken());
        T = Integer.valueOf(st.nextToken());


        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.valueOf(st.nextToken());
            I = Integer.valueOf(st.nextToken());
            C = Integer.valueOf(st.nextToken());
//            int time = binarySearch(T, S, I, C);
            int time = search(T, S, I, C);
            if(time > -1){
                result = Math.min(result, time);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result == Integer.MAX_VALUE ? -1 : result));
        bw.flush();
        bw.close();
    }

    static int binarySearch(int target, int first, int increase, int cnt){
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = first + (increase * i);
        }
        if (target > arr[cnt - 1]) {
            return -1;
        }

        int start = 0;
        int end = cnt;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            if (arr[mid] == target) {
                return 0;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[mid] - target;
    }

    static int search(int target, int first, int increase, int cnt){
        for (int i = 0; i < cnt; i++) {
            int time = first + (i * increase);
            if(target == first + (i * increase)){
                return 0;
            } else if(target < time){
                return time - target;
            }
        }
        return -1;
    }
}
/*
1 285
150 50 10
15
 */
