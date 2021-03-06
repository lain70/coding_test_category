package Dfs_Bfs;

import java.util.Arrays;

public class ColorBook {
    public static int[] nodeX = {0,1,0,-1};
    public static int[] nodeY = {1,0,-1,0};

    public static int nowAreaSize = 0;

    public static void bfs(int nowColor, boolean[][] visited, int x, int y, int[][] picture){

        if(visited[x][y] || (picture[x][y] != nowColor)){   //λ°©λ¬Έ? ???κ±°λ ??¬ ??΄ ??λ©? return
            return;
        }
        
        visited[x][y] = true;   //λ°©λ¬Έμ²λ¦¬
        nowAreaSize++;  // ??¬ ?? ??΄ μ¦κ?

        for(int i = 0; i < 4; i++){
            if( (0 <= x + nodeX[i] && x + nodeX[i] < picture.length) && (0 <= y + nodeY[i] && y + nodeY[i] < picture[0].length)){   // κ·Έλ¦Ό? λ²μλ₯? μ΄κ³Ό?μ§? ??Όλ©? ??
                bfs(nowColor, visited, x + nodeX[i], y + nodeY[i], picture);
            }
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        for(boolean[] visit : visited){
            Arrays.fill(visit, false);
        }

        int nowColor = 0;
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(picture[i][j] == 0 || visited[i][j]){
                    visited[i][j] = true;
                    continue;
                }

                // ?κΉμ΄ 0?΄ ??λ©΄μ λ°©λ¬Έ? ?μ§? ??? κ²½μ°
                nowColor = picture[i][j];
                numberOfArea++;
                nowAreaSize = 0;

                bfs(nowColor, visited, i, j, picture);

                if (nowAreaSize > maxSizeOfOneArea) {
                    maxSizeOfOneArea = nowAreaSize;
                }

            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        ColorBook cb = new ColorBook();

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] result = cb.solution(m,n,picture);

        for(int a : result){
            System.out.println(a);
        }


    }
}
