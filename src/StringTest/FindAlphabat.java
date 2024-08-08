package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char a = 'a';
        char z = 'z';
        int intZ = z;
        for(int i = a; i < intZ + 1; i++){
            System.out.print(s.indexOf(String.valueOf((char)i)) + " ");
        }
    }
}
