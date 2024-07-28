package TwoZeroTwoFour.CodingLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DfsBasic {
    public static void main(String[] args) {
        int n;

        boolean[] visited;
        List<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());

        visited = new boolean[n+1];
        Arrays.fill(visited, false);
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int j = 1; j < n+1; j++){
            int[] valArr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int val : valArr){
                graph.get(j).add(val);
            }
        }

        dfs(graph, 1, visited, result);

        for(Integer r : result){
            System.out.print(r + " ");
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, List<Integer> result){
        visited[v] = true;
        result.add(v);

        for(int i = 0; i < graph.get(v).size(); i++){
            if(!visited[graph.get(v).get(i)]){
                dfs(graph, graph.get(v).get(i), visited, result);
            }
        }

    }
}
