package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Poliomino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        int xCnt = 0;
        String stopCnt = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'X'){
                if(stopCnt.length() > 0){
                    sb.append(stopCnt);
                    stopCnt = "";
                }
                xCnt++;
            }else {
                if(xCnt > 0){
                    if(xCnt % 2 == 1){
                        sb = new StringBuilder("-1");
                        break;
                    }
                    appendAB(sb, xCnt);
                    xCnt = 0;
                }
                stopCnt += ".";
            }
        }

        if(stopCnt.length() > 0){
            sb.append(stopCnt);
        }

        if(xCnt > 0){
            if(xCnt % 2 == 1){
                sb = new StringBuilder("-1");
            }else{
                appendAB(sb, xCnt);
            }
        }

        System.out.println(sb);
    }

    static void appendAB(StringBuilder sb, int len) {
        String first = "AAAA";
        String second = "BB";

        int firstCnt = len / 4;
        int secntCnt = len % 4;
        for(int k = 0; k < firstCnt; k++){
            sb.append(first);
        }
        if(secntCnt > 0){
            sb.append(second);
        }
    }
}
