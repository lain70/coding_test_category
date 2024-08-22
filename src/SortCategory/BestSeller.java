package SortCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(br.readLine());
        }

        Collections.sort(list, (a, b) -> a.compareTo(b));

        Map<String, Integer> map = new HashMap<>();

        String maxName = "";
        int max = 0;
        for(int i = 0; i < n; i++){
            int cnt = map.containsKey(list.get(i))? map.get(list.get(i)) + 1: 1;
            map.put(list.get(i), cnt);
            if(cnt > max){
                max = cnt;
                maxName = list.get(i);
            }
        }

        System.out.println(maxName);

    }
}
