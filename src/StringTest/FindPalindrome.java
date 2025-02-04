package StringTest;

import java.io.*;

public class FindPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());

        for (int i = 0; i < n; i++){
            String str = br.readLine();
            int result = find(str);
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static int find(String str){
        int len = str.length();
        int start = 0;
        int end = len - 1;
        if(len % 2 == 0){
            while(start <= end){
                if(str.charAt(start) != str.charAt(end)){
                    return 2;
                }
                start++;
                end--;
            }
            return 0;
        }else{
            while(start <= end){
                if(str.charAt(start) != str.charAt(end)){
                    if(start + 1 < end && str.charAt(start+1) == str.charAt(end)){
                        start++;
                    }else if(start < end - 1 && str.charAt(start) == str.charAt(end-1)){
                        end--;
                    }else {
                        return 1;
                    }
                }
                start++;
                end--;
            }
            return 1;
        }
    }
}
