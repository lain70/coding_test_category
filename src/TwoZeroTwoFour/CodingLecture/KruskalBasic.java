package TwoZeroTwoFour.CodingLecture;

import java.util.*;

public class KruskalBasic {
    public static int[] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1];
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        PriorityQueue<int[]> graph = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for(int i = 0; i < m; i++){
            graph.offer(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        int cost = 0;
        while(!graph.isEmpty()){
            int[] g = graph.poll();
            int a = g[0];
            int b = g[1];

            if(findParents(a) != findParents(b)){
                unionParents(a, b);
                cost += g[2];
            }
        }

        System.out.println(cost);
    }
    
    private static int findParents(int a){
        if(parents[a] != a) {
            return parents[a] = findParents(parents[a]);
        }
            return parents[a];
            
    }
    
    private static void unionParents(int a, int b){
        int aP = findParents(a);
        int bP = findParents(b);
        if(aP < bP){
            parents[bP] = aP;
        }else{
            parents[aP] = bP;
        }
    }
}
