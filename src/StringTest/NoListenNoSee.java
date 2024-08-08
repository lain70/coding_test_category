package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NoListenNoSee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        List<String> resultList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String s = br.readLine();
            if(!set.add(s)){
                resultList.add(s);
            }
        }

        resultList.sort((a,b)->a.compareTo(b));
        System.out.println(resultList.size());
        for(String s : resultList){
            System.out.println(s);
        }
    }
}
