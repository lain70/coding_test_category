package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 9251
public class LcsBasic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        char[] charArrA = a.toCharArray();
        char[] charArrB = b.toCharArray();

        int[][] arr = new int[charArrA.length + 1][charArrB.length + 1];
        arr[0][0] = 0;

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j <arr[0].length; j++){
                if(charArrA[i-1] == charArrB[j-1]){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else{
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                }
            }
        }

        System.out.println(arr[arr.length - 1][arr[0].length - 1]);

    }
}
