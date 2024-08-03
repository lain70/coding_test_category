package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Baekjoon11478
public class Baekjoon11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Set<String> set = new HashSet<>();
        for(int i = 1 ; i < s.length()+1; i++){
            for(int j = 0 ; j <= s.length()- i; j++){
                set.add(s.substring(j,j+i));
            }
        }
        System.out.println(set.size());
    }
}
