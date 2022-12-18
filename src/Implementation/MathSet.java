package Implementation;

import java.io.*;
import java.util.StringTokenizer;

//백준 11723 0~20까지의 배열을 만들어서 공집합에 있는경우 1, 없는 경우 0으로 간주한다.
public class MathSet {
    public static void main(String[] args) throws IOException {
        boolean[] mathArr = new boolean[21];
        int t= 1; while(t<mathArr.length){mathArr[t] = false; t++;}
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < m){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int num = 0;
            if(st.hasMoreElements()){
                num = Integer.parseInt(st.nextToken());
            }
            switch (method){
                case "add":mathArr[num] = true; break;
                case "remove":mathArr[num] = false; break;
                case "check":sb.append((mathArr[num]?1:0) + "\n");break;
                case "toggle": mathArr[num] = !mathArr[num]; break;
                case "all":int j= 1; while(j<mathArr.length){mathArr[j] = true; j++;} break;
                default:int k= 1; while(k<mathArr.length){mathArr[k] = false; k++;}
            }
            i++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush(); bw.close();
    }

}
