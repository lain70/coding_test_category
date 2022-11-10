package Dfs_Bfs;

import java.util.*;

/*
백준 2644
 */
public class FindRelative {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int result = -1;

    public static void dfs(int start, int end, int cnt){
        if(start == end){
            result = cnt;
            return;
        }

        visited[start] = true;
        for(int i = 0; i <graph.get(start).size(); i++){
            if(!visited[graph.get(start).get(i)]){
                dfs(graph.get(start).get(i), end, cnt+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[n+1];
        Arrays.fill(visited,false);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = input[0];
        int y = input[1];

        int m = Integer.valueOf(sc.nextLine());

        for(int i = 0 ; i < m; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        dfs(x,y,0);
        Arrays.fill(visited, false);
        dfs(y,x,0);

        System.out.println(result);
    }
}
