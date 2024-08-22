package Graph_Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ChickenWar {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());
        parents = new int[n + 1];

        ArrayList<Integer>[] friendList = new ArrayList[n + 1];
        ArrayList<Integer>[] enemyList = new ArrayList[n + 1];
        for(int i = 1; i <=n; i++){
            parents[i] = i;
            friendList[i] = new ArrayList<>();
            enemyList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            if("E".equals(str)){
                enemyList[a].add(b);
                enemyList[b].add(a);
            }else{
                friendList[a].add(b);
                friendList[b].add(a);
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < enemyList[i].size(); j++){
                int b = enemyList[i].get(j);
                for(int k = 0; k < enemyList[b].size(); k++){
                    int c = enemyList[b].get(k);
                    unionP(i,c);
                }
            }
        }

        for(int i = 1 ; i <= n; i++){
            for(int j = 0; j < friendList[i].size(); j++){
                int b = friendList[i].get(j);
                unionP(i, b);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            set.add(parents[i]);
        }

        System.out.println(set.size());
    }

    static int findP(int a){
        if(parents[a] == a) return parents[a];
        return parents[a] = findP(parents[a]);
    }

    static void unionP(int a, int b){
        a = findP(a);
        b = findP(b);

        if(a < b) {
            parents[b] = a;
        }else{
            parents[a] = b;
        }

    }
}
