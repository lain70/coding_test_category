package Greed;

import java.io.*;
import java.util.Stack;

//backjoon 2810
public class CupHolder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String str = br.readLine();
        StringBuilder sb = new StringBuilder("*");

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'S'){
                sb.append("S" + "*");
            }else{
                sb.append("LL" + "*");
                i++;
            }
        }

        String plusStar = sb.toString();
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < plusStar.length(); i++){
            if(stk.isEmpty()){
                stk.push(plusStar.charAt(i));
                continue;
            }

            if(plusStar.charAt(i) != '*'){
                if(stk.peek() == '*'){
                    stk.pop();
                }else {
                    stk.push(plusStar.charAt(i));
                }
            }else{
                if(stk.peek() != '*'){
                    stk.pop();
                }else {
                    stk.push(plusStar.charAt(i));
                }
            }
        }

        int cnt = 0;
        while (!stk.isEmpty()){
            if(stk.pop() != '*'){
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(n - cnt));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
