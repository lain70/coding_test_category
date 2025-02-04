package Graph_Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//backjoon 17352
public class MakeBridgeForYou {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        parents = new int[n + 1];
        for(int i = 1; i <=n; i++){
            parents[i] = i;
        }


        StringTokenizer st;
        for(int i = 0; i < n-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            unionP(a,b);
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < parents.length; i++){
            if(findP(i) == i){
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    static int findP(int a){
        if(parents[a] == a) return a;
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
