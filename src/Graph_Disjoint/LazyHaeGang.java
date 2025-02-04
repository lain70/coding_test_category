package Graph_Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//backjoon 24391
public class LazyHaeGang {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            unionP(a, b);
        }


        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        int pre = Integer.valueOf(st.nextToken());
        for(int i = 0; i < n - 1; i++){
            int next = Integer.valueOf(st.nextToken());
            if (findP(pre) != findP(next)) {
                cnt++;
            }
            pre = next;
        }

        System.out.println(cnt);
    }

    static int findP(int a){
        if(parents[a] == a) return a;
        return parents[a] = findP(parents[a]);
    }

    static void unionP(int a, int b){
        a = findP(a);
        b = findP(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
