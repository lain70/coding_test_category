package TwoZeroTwoFour.CodingLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());

        List<int[][]> mineList = new ArrayList<>();
        for(int i = 0; i < t; i++){
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = input[0], m = input[1];

            int[][] mine = new int[n][m+1];

            int[] input2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int sel = 0;
            for(int j = 0; j < n; j++){
                mine[j][0] = 0;
                for(int k = 1; k < m+1; k++){
                    mine[j][k] = input2[sel];
                    sel++;
                }
            }

            mineList.add(mine);
        }

        for(int[][] mine : mineList){
            int[][] d = new int[mine.length][mine[0].length];
            for(int[] di : d){
                Arrays.fill(di, 0);
            }

            for(int i = 1; i < mine[0].length; i++){
                for(int j = 0; j < mine.length; j++){
                    // 왼쪽 옆
                    d[j][i] = Math.max(d[j][i], d[j][i-1] + mine[j][i]);

                    // 왼쪽 위
                    if(j - 1 >= 0){
                        d[j][i] = Math.max(d[j][i], d[j-1][i-1] + mine[j][i]);
                    }

                    // 왼쪽 아래
                    if(j + 1 < mine.length){
                        d[j][i] = Math.max(d[j][i], d[j+1][i-1] + mine[j][i]);
                    }
                }
            }

            int max = 0;
            for(int i = 0; i < d.length; i++){
                max = Math.max(max, d[i][mine[0].length - 1]);
            }
            System.out.println(max);
        }
    }
}
/**
 * 1 3 1 5
 * 2 2 4 1
 * 5 0 2 3
 * 0 6 1 2
 */