package StringTest;

import java.io.*;

public class FindDoc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String find = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc2 = doc.replaceAll(find, "1");
        int cnt = 0;
        for (int i = 0; i < doc2.length(); i++) {
            if ('1' == doc2.charAt(i)) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
