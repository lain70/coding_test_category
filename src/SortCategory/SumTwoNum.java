package SortCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SumTwoNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()){
            a[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int x = Integer.parseInt(br.readLine());

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        Collections.sort(list);

        int[] sortedA = list.stream().mapToInt(Integer::intValue).toArray();

        int start = 0;
        int end = sortedA.length - 1;

        int result = 0;
        while (start < end){
            int nowSum = sortedA[start] + sortedA[end];
            if(nowSum == x){
                result += 1;
                start++;
                end--;
            } else if (nowSum < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }
}
