package DisjoinSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//백준 1043
public class LierJiMin{
    static int[] parents;
    static List<Integer> whiteList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for(int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int whiteNum = Integer.parseInt(st.nextToken());
        if(whiteNum == 0){
            System.out.println(m);
            return;
        }
        whiteList = new ArrayList<>();
        for(int i = 0; i < whiteNum; i++){
            whiteList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(whiteList);

        List<Integer>[] partyList = new ArrayList[m];
        for(int i =0; i < m; i++){
            partyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);
            for(int j = 1; j < partyPeople; j++){
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList[i].add(y);
            }
        }

        int cnt = 0;
        for(int i = 0; i < m; i++){
            boolean lie = false;
            for(int j = 0; j < partyList[i].size(); j++){
                if(Collections.binarySearch(whiteList, findParents(partyList[i].get(j))) > -1){

                    lie = true;
                    break;
                }
            }
            if(!lie){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int findParents(int a){
        if(parents[a] != a) return findParents(parents[a]);
        else return parents[a];
    }

    static void union(int x, int y){
        int px = findParents(x);
        int py = findParents(y);

        if(Collections.binarySearch(whiteList, py) > -1){
            parents[px] = py;
        }else{
            parents[py] = px;
        }
    }
}
