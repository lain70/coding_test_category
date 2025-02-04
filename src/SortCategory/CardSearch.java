package SortCategory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 10816 백준
public class CardSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Integer[] cards = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.valueOf(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MIN_VALUE,max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int card = cards[i];
            min = Math.min(min, card);
            max = Math.max(max, card);
            if(map.containsKey(card)){
                map.put(card, map.get(card) + 1);
            }else {
                map.put(card, 1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.valueOf(st.nextToken());
            if (target < min || target > max) {
                bw.write("0 ");
            } else {
                if(map.containsKey(target)){
                    bw.write(String.valueOf(map.get(target)) + " ");
                }else {
                    bw.write("0 ");
                }

            }
        }
        bw.flush();
        bw.close();
    }
}
/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */