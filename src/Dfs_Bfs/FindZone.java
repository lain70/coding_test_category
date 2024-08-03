package Dfs_Bfs;

import java.io.*;
import java.util.*;

//백준 2583
public class FindZone {
    public static int[] mX = {1,-1,0,0};
    public static int[] mY = {0,0,-1,1};
    public static int[][] map;
    static int m, n, k, range;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        map = new int[m][n];
        for(int[] m : map){
            Arrays.fill(m, 0);
        }

        for(int i = 0; i < k; i++){
            int[] square = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = square[1]; j < square[3]; j++){
                for(int k = square[0]; k < square[2]; k++){
                    map[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0){
                    range = 0;
                    if(dfs(i,j)){
                        result.add(range);
                        cnt++;
                    }
                }
            }
        }

        Collections.sort(result);

        System.out.println(cnt);
        for (int r : result){
            System.out.print(r + " ");
        }
    }

    static boolean dfs(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n){
            return false;
        }

        if(map[x][y] == 0){
            map[x][y] = 1;
            range += 1;
            for(int i = 0; i < 4; i++){
                int nX = x + mX[i], nY = y + mY[i];
                dfs(nX, nY);
            }
            return true;
        }
        return false;
    }
}
