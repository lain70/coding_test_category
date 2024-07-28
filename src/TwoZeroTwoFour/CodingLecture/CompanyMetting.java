package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class CompanyMetting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1];

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], 100001);
             graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[info[0]][info[1]] = 1;
            graph[info[1]][info[0]] = 1;
        }

        int[] input2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = input2[0], k = input2[1];

        for(int c = 1; c < n + 1; c++){
            for(int a = 1; a < n + 1; a++){
                for(int b = 1; b < n + 1; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][c] + graph[c][b]);
                }
            }
        }

        if(graph[1][k] == 100001 || graph[k][x] == 100001){
            System.out.println(-1);
        }else {
            System.out.println(graph[1][k] + graph[k][x]);
        }
    }
}
