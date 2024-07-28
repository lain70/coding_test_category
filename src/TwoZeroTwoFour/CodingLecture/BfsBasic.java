package TwoZeroTwoFour.CodingLecture;

import java.util.*;

public class BfsBasic {
    public static void main(String[] args) {
        int n;
        boolean[] visited;
        List<Integer> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int j = 1; j < n+1; j++){
            int[] valArr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int val : valArr){
                graph.get(j).add(val);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            result.add(v);

            for(int val : graph.get(v)){
                if(!visited[val]){
                    queue.offer(val);
                    visited[val] = true;
                }
            }
        }

        for(int r : result){
            System.out.print(r + " ");
        }
    }
}
