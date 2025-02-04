package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//backjoon 12904
public class AandB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() < t.length()) {
            if(t.charAt(t.length() - 1) == 'A'){
                t = t.substring(0, t.length() - 1);
            }else {
                t = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
            }
        }
        System.out.println(s.equals(t) ? 1 : 0);
    }
}
