package StringTest;

import java.io.*;
import java.util.Arrays;

public class PhoneNumberList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.valueOf(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.valueOf(br.readLine());
            String[] arr = new String[n];
            for(int j = 0; j < n; j++){
                String str = br.readLine();
                arr[j] = str;
            }
            Arrays.sort(arr);
            String result = valid(arr);
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static String valid(String[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+1].startsWith(arr[i])){
                return "NO";
            }
        }
        return "YES";
    }
}
