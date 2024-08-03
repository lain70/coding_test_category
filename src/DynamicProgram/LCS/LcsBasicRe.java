package DynamicProgram.LCS;

import java.util.Scanner;

// 백준 9251
// 최장 공통 부분수열
public class LcsBasicRe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        char[] ca1 = str1.toCharArray();
        char[] ca2 = str2.toCharArray();

        int[][] d = new int[ca1.length + 1][ca2.length + 1];
        d[0][0] = 0;

        for(int i = 1; i < ca1.length + 1; i++){
            for(int j = 1; j < ca2.length + 1; j++){
                if (ca1[i - 1] == ca2[j - 1]) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = Math.max(d[i][j - 1], d[i - 1][j]);
                }
            }
        }

        System.out.println(d[d.length - 1][d[0].length - 1]);
    }
}
