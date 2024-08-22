package SortCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OldSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        List<String[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            list.add(new String[]{String.valueOf(i), a, b});
        }

        Collections.sort(list, (a,b) -> {
            if(Integer.valueOf(a[1]).equals(Integer.valueOf(b[1]))){
                return Integer.valueOf(a[0]) - Integer.valueOf(b[0]);
            }
            return Integer.valueOf(a[1]) - Integer.valueOf(b[1]);
        });

        for(String[] re : list){
            System.out.println(re[1] + " " + re[2]);
        }
    }
}
