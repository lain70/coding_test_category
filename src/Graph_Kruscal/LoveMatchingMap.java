package Graph_Kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LoveMatchingMap {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        String[] gender = new String[n + 1];
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            gender[i] = st.nextToken();
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            pq.offer(new int[]{a, b, cost});
        }

        int allCost = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int a = now[0];
            int b = now[1];
            int c = now[2];

            if (!gender[a].equals(gender[b]) && findP(a) != findP(b)) {
                unionP(a, b);
                allCost += c;
            }
        }

        for(int i = 2; i <= n; i++){
            if (findP(i) != findP(i -1)) {
                allCost = -1;
            }
        }

        System.out.println(allCost);
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