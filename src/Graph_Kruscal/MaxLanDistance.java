package Graph_Kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MaxLanDistance {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int allCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                int c = charToInt(str.charAt(j));
                pq.offer(new int[]{i, j, c});
                allCost += c;
            }
        }

        int minCost = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int a = now[0];
            int b = now[1];
            int c = now[2];

            if(findP(a) != findP(b) && c > 0){
                unionP(a, b);
                minCost += now[2];
            }
        }

        int result = allCost - minCost;
        for (int i = 1; i < n; i++) {
            if (findP(i) != findP(i - 1)) {
                result = -1;
            }
        }

        System.out.println(result);
    }

    static int charToInt(char in){
        if(in == '0'){
            return 0;
        }
        int ch = in;
        if(ch >96){
            return ch - 96;
        }else{
            return ch - 38;
        }

    }

    static int findP(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findP(parents[a]);
    }

    static void unionP(int a, int b) {
        a = findP(a);
        b = findP(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}