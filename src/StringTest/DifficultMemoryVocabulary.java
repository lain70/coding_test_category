package StringTest;

import java.io.*;
import java.util.*;

public class DifficultMemoryVocabulary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());

        List<String[]> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length() >= m){
                if(map.containsKey(str)){
                    map.put(str, map.get(str) + 1);
                }else{
                    map.put(str, 1);
                }
            }
        }

        for (String key : map.keySet()) {
            list.add(new String[]{key, String.valueOf(map.get(key))});
        }

        Collections.sort(list, (a,b)->{
            int cntA = Integer.valueOf(a[1]);
            int cntB = Integer.valueOf(b[1]);
            if(cntB == cntA){
                if(b[0].length() == a[0].length()){
                    return a[0].compareTo(b[0]);
                }else{
                    return b[0].length() - a[0].length();
                }
            }else{
                return  cntB - cntA;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String[] reStr : list){
            bw.write(reStr[0]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
