package Graph_Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CycleGame {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        int result = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            if(findP(a) == findP(b) && result == 0){
                result = i + 1;
            }
            unionP(a,b);
        }
        System.out.println(result);
    }

    static int findP(int a){
        if(parents[a] == a){
            return parents[a];
        }
        return parents[a] = findP(parents[a]);
    }

    static void unionP(int a, int b){
        a = findP(a);
        b = findP(b);
        if(a < b){
            parents[b] = a;
        }else {
            parents[a] = b;
        }

    }
}
