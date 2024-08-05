package SortCategory;

import java.io.*;
import java.util.*;

public class WordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }else {
                return a.length() - b.length();
            }
        });

        for(String str : set){
            queue.offer(str);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
