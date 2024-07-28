package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class FloidWBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());

        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i ++){
            Arrays.fill(graph[i], 100001);
            graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[input[0]][input[1]] = input[2];
        }

        for(int a = 1; a < n+1; a++){
            for(int b = 1; b < n+1; b++){
                for(int k = 1; k < n+1; k++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
