package SearchCategory;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;
//백준 2110
public class BuildRouter {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] homes = new int[n];
        for(int i = 0; i < n; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = Arrays.stream(homes).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int[] sortHomes = list.stream().mapToInt(i -> i).toArray();

        int start  = 1;
        int end = sortHomes[n-1];

        while(start <= end){
            int mid = (start + end) / 2;

            int cnt = 1;
            int pre = sortHomes[0];
            for(int i = 1; i < n; i++){
                int now = sortHomes[i];

                if(now - pre >= mid){
                    cnt++;
                    pre = now;
                }
            }
            if(cnt < c){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        System.out.println(start - 1);
    }
}
