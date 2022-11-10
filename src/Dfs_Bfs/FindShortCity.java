package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindShortCity {

    public static ArrayList<ArrayList<Integer>> graph;
    public static int visited[];
    public static ArrayList<Integer> resultList = new ArrayList<>();

    public static void dfs(int start, int cnt){

        visited[start] = Math.min(visited[start],cnt );
        for(int i = 0; i < graph.get(start).size(); i++){
            dfs(graph.get(start).get(i), cnt+1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int k = input[2];
        int x = input[3];

        graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        visited = new int[n+1];
        Arrays.fill(visited, 1000001);

        for(int i = 0; i < m; i++){
            int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(v[0]).add(v[1]);
        }

        dfs(x,0);
        for(int i = 0 ; i < visited.length; i++){
            if(visited[i] == k){
                resultList.add(i);
            }
        }
        if(resultList.size() == 0){
            System.out.println(-1);
        }else {
            for(Integer r : resultList){
                System.out.println(r);
            }
        }

    }
}
