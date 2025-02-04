package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class StringDivine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 2; i++) {
            for(int j = i+1; j < str.length() - 1; j++){
                String str1 = str.substring(0, i + 1);
                String str2 = str.substring(i+1, j + 1);
                String str3 = str.substring(j + 1);

                String newStr = new StringBuilder(str1).reverse().append(new StringBuffer(str2).reverse().append(new StringBuffer(str3).reverse())).toString();
                list.add(newStr);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
