package Graph_Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlowFlute {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        parents = new int[n * m + 1];
        for(int i = 0; i < n * m + 1; i++){
            parents[i] = i;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                int a = (i * m) + (j+1);
                int b = 1;
                switch (input.charAt(j)){
                    case 'D': b = a + m; break;
                    case 'U': b = a - m; break;
                    case 'R': b = a + 1; break;
                    default: b = a - 1;
                }

                if(findP(a) == findP(b)){
                    cnt++;
                }else {
                    unionP(a, b);
                }
            }
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
        }else {
            parents[a] = b;
        }
    }
}
