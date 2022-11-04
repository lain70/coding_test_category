package Greed_Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NCruscal {
    public static int findParents(int[] parents, int x){
        if(parents[x] == x) return x;
        return parents[x] = findParents(parents, parents[x]);
    }

    public static void union(int[] parents, int a, int b){
        a = findParents(parents, a);
        b = findParents(parents, b);

        if(a < b){
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());

        int[] parents = new int[n+1];
        for(int i = 0 ; i < n+1; i++){
            parents[i] = i;
        }
        int[][] graph = new int[m][3];

        for(int i = 0; i < m; i++){
            graph[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int result = 0;
        for(int i = 0; i < m; i++){
            if(findParents(parents, graph[i][0]) != findParents(parents, graph[i][1])){
                union(parents, graph[i][0], graph[i][1]);
                result += graph[i][2];
            }
        }

        System.out.println(result);
    }
}
