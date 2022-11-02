package Dfs_Bfs;

import java.util.Arrays;
import java.util.Scanner;

public class NMakeIce {
    public static int[] mX = new int[]{1,-1,0,0};
    public static int[] mY = new int[]{0,0,-1,1};

    public static int n;
    public static int m;
    public static int[][] iceMaker;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        m = Integer.valueOf(sc.nextLine());

        iceMaker = new int[n][m];
        for(int i = 0; i < n; i++){
            iceMaker[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j =0; j< m; j++){
                if(dfs(i,j)){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean dfs(int x, int y){
        if(x < 0 || x>=n || y < 0 || y >= m){
            return false;
        }
        if(iceMaker[x][y] == 0){
            iceMaker[x][y] = 1;
            for(int i = 0; i < 4; i++){
                dfs(x+mX[i],y+mY[i]);
            }
            return true;
        }else{
            return false;
        }
    }
}
