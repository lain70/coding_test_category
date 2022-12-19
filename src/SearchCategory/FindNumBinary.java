package SearchCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindNumBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        List<Integer> listA = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            listA.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(listA);
        arrA = listA.stream().mapToInt(Integer::intValue).toArray();


        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int input = Integer.parseInt(st.nextToken());
            sb.append(((Arrays.binarySearch(arrA, input) > -1)?1:0)+"\n");
        }
        System.out.println(sb);

    }

}
