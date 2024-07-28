package TwoZeroTwoFour.CodingLecture;

import java.util.*;

public class DijkstraBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1];
        int start = Integer.valueOf(sc.nextLine());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // info0 : node, info1 : graph, info2 : distance
            graph.get(info[0]).add(new int[]{info[1], info[2]});
        }

        int[] d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        que.offer(new int[]{start, 0});
        while (!que.isEmpty()){
            int[] now = que.poll();
            int nowIdx = now[0], nowDistance = now[1];

            if(d[nowIdx] < nowDistance) continue;

            for(int i = 0; i < graph.get(nowIdx).size(); i++){
                int cost = d[nowIdx] + graph.get(nowIdx).get(i)[1];
                if(cost < d[graph.get(nowIdx).get(i)[0]]){
                    d[graph.get(nowIdx).get(i)[0]] = cost;
                    que.offer(new int[]{graph.get(nowIdx).get(i)[0], graph.get(nowIdx).get(i)[1]});
                }
            }
        }

        for(int dis : d){
            if(dis != Integer.MAX_VALUE){
                System.out.println(dis);
            }
        }
    }

}
