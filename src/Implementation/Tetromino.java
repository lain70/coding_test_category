package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백준 14500
public class Tetromino {
    public static void main(String[] args) throws IOException {
        //폴리오미노를 회전 대칭 시켰을때 가능한 경우는 총 19가지이다.
        ArrayList<ArrayList<int[]>> tetoList = new ArrayList<>();
        for(int i = 0 ; i < 19; i++){
            tetoList.add(new ArrayList<int[]>());
        }

        // ㅣ자 모양
        for(int i = 0; i < 4; i++){
            tetoList.get(0).add(new int[]{0,i});
            tetoList.get(1).add(new int[]{i,0});
        }

        //ㅁ자모양
        tetoList.get(2).add(new int[]{0,0});
        tetoList.get(2).add(new int[]{0,1});
        tetoList.get(2).add(new int[]{1,0});
        tetoList.get(2).add(new int[]{1,1});

        // L자 모양
        tetoList.get(3).add(new int[]{0,0});
        tetoList.get(3).add(new int[]{1,0});
        tetoList.get(3).add(new int[]{2,0});
        tetoList.get(3).add(new int[]{2,1});

        tetoList.get(4).add(new int[]{0,0});
        tetoList.get(4).add(new int[]{0,1});
        tetoList.get(4).add(new int[]{0,2});
        tetoList.get(4).add(new int[]{-1,2});

        tetoList.get(5).add(new int[]{0,0});
        tetoList.get(5).add(new int[]{0,1});
        tetoList.get(5).add(new int[]{1,1});
        tetoList.get(5).add(new int[]{2,1});

        tetoList.get(6).add(new int[]{0,0});
        tetoList.get(6).add(new int[]{-1,0});
        tetoList.get(6).add(new int[]{-1,1});
        tetoList.get(6).add(new int[]{-1,2});

        //L자 회전
        tetoList.get(7).add(new int[]{0,0});
        tetoList.get(7).add(new int[]{1,0});
        tetoList.get(7).add(new int[]{2,0});
        tetoList.get(7).add(new int[]{2,-1});

        tetoList.get(8).add(new int[]{0,0});
        tetoList.get(8).add(new int[]{1,0});
        tetoList.get(8).add(new int[]{1,1});
        tetoList.get(8).add(new int[]{1,2});

        tetoList.get(9).add(new int[]{0,0});
        tetoList.get(9).add(new int[]{0,1});
        tetoList.get(9).add(new int[]{1,0});
        tetoList.get(9).add(new int[]{2,0});

        tetoList.get(10).add(new int[]{0,0});
        tetoList.get(10).add(new int[]{0,1});
        tetoList.get(10).add(new int[]{0,2});
        tetoList.get(10).add(new int[]{1,2});

        // N모양
        tetoList.get(11).add(new int[]{0,0});
        tetoList.get(11).add(new int[]{1,0});
        tetoList.get(11).add(new int[]{1,1});
        tetoList.get(11).add(new int[]{2,1});

        tetoList.get(12).add(new int[]{0,0});
        tetoList.get(12).add(new int[]{1,0});
        tetoList.get(12).add(new int[]{1,-1});
        tetoList.get(12).add(new int[]{2,-1});

        tetoList.get(13).add(new int[]{0,0});
        tetoList.get(13).add(new int[]{0,1});
        tetoList.get(13).add(new int[]{1,1});
        tetoList.get(13).add(new int[]{1,2});

        tetoList.get(14).add(new int[]{0,0});
        tetoList.get(14).add(new int[]{0,-1});
        tetoList.get(14).add(new int[]{1,-1});
        tetoList.get(14).add(new int[]{1,-2});

        // ㅗ모양
        tetoList.get(15).add(new int[]{0,0});
        tetoList.get(15).add(new int[]{0,1});
        tetoList.get(15).add(new int[]{0,2});
        tetoList.get(15).add(new int[]{1,1});

        tetoList.get(16).add(new int[]{0,0});
        tetoList.get(16).add(new int[]{0,1});
        tetoList.get(16).add(new int[]{0,2});
        tetoList.get(16).add(new int[]{-1,1});

        tetoList.get(17).add(new int[]{0,0});
        tetoList.get(17).add(new int[]{1,0});
        tetoList.get(17).add(new int[]{2,0});
        tetoList.get(17).add(new int[]{1,1});

        tetoList.get(18).add(new int[]{0,0});
        tetoList.get(18).add(new int[]{1,0});
        tetoList.get(18).add(new int[]{2,0});
        tetoList.get(18).add(new int[]{1,-1});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreElements()){
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < tetoList.size(); k++){
                    int sum = 0;
                    for(int p = 0; p <tetoList.get(k).size(); p++){
                        int[] now = tetoList.get(k).get(p);

                        int mx = i + now[0];
                        int my = j + now[1];

                        if(mx < 0 || mx >= n || my < 0 || my >= m){
                            sum = 0; break;
                        }
                        sum += map[mx][my];
                    }
                    result = Math.max(result, sum);
                }
            }
        }

        System.out.println(result);


    }
}
