package Greed_TopologicalSort;

import java.util.*;

public class NTopological {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = Integer.valueOf(sc.nextLine());
        int e = Integer.valueOf(sc.nextLine());

        int[] indgr = new int[v+1];
        Arrays.fill(indgr,0);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < e; i++){
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(input[0]).add(input[1]);
            indgr[input[1]] += 1;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= v; i++){
            if(indgr[i] == 0){
                que.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()){
            int tmp = que.poll();

            for(int i = 0; i < graph.get(tmp).size(); i++){
                indgr[graph.get(tmp).get(i)] -= 1;

                if(indgr[graph.get(tmp).get(i)] == 0){
                    que.offer(graph.get(tmp).get(i));
                }
            }

            if(!que.isEmpty()){
                sb.append(tmp + " ");
            }else {
                sb.append(tmp);
            }
        }

        System.out.println(sb.toString());
    }
}
