package DisjoinSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeFriends {
    static int[] parents;
    static int[] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //부모 배열 초기화
        parents = new int[n+1];
        for(int i = 1; i < n+1; i++){
            parents[i] = i;
        }

        //친구비 입력
        costs = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        //union 함수 실행
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x,y);
        }

        int sum = 0;
        for(int i = 1; i < n+1; i++){
            if(i == parents[i]){
                sum += costs[i];
                if(sum > k){
                    sum = -1;
                    break;
                }
            }
        }

        System.out.println(sum==-1?"Oh no":sum);
    }

    static int find(int x){
        if(parents[x] == x) return parents[x];
        else return find(parents[x]);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(costs[px] <= costs[py]){
            parents[py] = parents[px];
        }else {
            parents[px] = parents[py];
        }
    }
}
