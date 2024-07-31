package TwoZeroTwoFour.CodingLecture;

import java.util.*;

public class topologySortBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = input[0], e = input[1];

        int[] indegree = new int[v+1];
        Arrays.fill(indegree, 0);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < e; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < e; i++){
            int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(info[0]).add(info[1]);
            indegree[info[1]] += 1;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i < v + 1; i++){
            if(indegree[i] == 0){
                que.offer(i);
                break;
            }
        }

        while (!que.isEmpty()){
            int now = que.poll();
            sb.append(now + " ");

            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;

                if(indegree[graph.get(now).get(i)] == 0){
                    que.offer(graph.get(now).get(i));
                }
            }
        }

        System.out.println(sb);
    }
}
