package StringTest;

import java.io.*;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 0;
        char now = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (now != str.charAt(i)) {
                cnt++;
                now = str.charAt(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf((cnt + 1) / 2));
        bw.flush();
        bw.close();
    }
}