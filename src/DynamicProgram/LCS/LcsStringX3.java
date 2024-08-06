package DynamicProgram.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1958
public class LcsStringX3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();

        int[][][] arr = new int[str1.length + 1][str2.length + 1][str3.length + 1];
        arr[0][0][0] = 0;

        for(int i = 1; i < str1.length+1; i++){
            for(int j = 1; j < str2.length+1; j++){
                for(int k = 1; k < str3.length+1; k++){
                    if(str1[i-1] == str2[j-1] && str2[j-1] == str3[k-1]){
                       arr[i][j][k] = arr[i-1][j-1][k-1] + 1;
                    }else {
                        arr[i][j][k] = Math.max(arr[i-1][j][k],Math.max(arr[i][j-1][k],arr[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(arr[str1.length][str2.length][str3.length]);
    }
}
