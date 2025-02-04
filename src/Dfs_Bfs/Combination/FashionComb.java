package Dfs_Bfs.Combination;

import java.io.*;
import java.util.*;

public class FashionComb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int m = Integer.valueOf(br.readLine());
        for(int i = 0 ; i < m; i++){
            int n = Integer.valueOf(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                String wear = st.nextToken();
                String type = st.nextToken();
                if(map.containsKey(type)){
                    map.put(type, map.get(type) + 1);
                }else {
                    map.put(type, 1);
                }
            }
            int cnt = cal(map);
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int cal(Map<String, Integer> map){
        int cnt = 1;
        for (String key : map.keySet()) {
            cnt *= map.get(key) + 1;
        }
        return cnt - 1;
    }
}
