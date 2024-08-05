package SearchCategory.BinarySearchCate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindCardNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            cards[i] = Integer.valueOf(st.nextToken());
            i++;
        }
        Arrays.sort(cards);

        int m = Integer.valueOf(br.readLine());
        int[] targets = new int[m];

        st = new StringTokenizer(br.readLine());
        i = 0;
        while (st.hasMoreTokens()) {
            targets[i] = binarySearch(cards, Integer.valueOf(st.nextToken()));
            i++;
        }

        for(int target : targets){
            System.out.print(target + " ");
        }
    }

    static int binarySearch(int[] arr, int target){
        int start = 0, end = arr.length, mid;
        while (start < end){
            mid = (start + end) / 2;

            if(arr[mid] == target){
                return 1;
            }

            if(arr[mid] > target){
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
