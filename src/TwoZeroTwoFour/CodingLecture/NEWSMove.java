package TwoZeroTwoFour.CodingLecture;

import java.util.Arrays;
import java.util.Scanner;

public class NEWSMove {
    public static void main(String[] args) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        int n;
        String[] move;

        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        move = new String[n];
        move = sc.nextLine().split(" ");

        int mX = 1, mY = 1;
        for(String next : move){
            switch (next){
                case "R": mY = mY + 1 <= n? mY + 1: mY; break;
                case "L": mY = mY - 1 >= 1? mY - 1: mY; break;
                case "D": mX = mX + 1 <= n? mX + 1: mX; break;
                default: mX = mX - 1 >= 1? mX - 1: mX; break;
            }
        }
        System.out.println(mX + " " +mY);
    }
}
