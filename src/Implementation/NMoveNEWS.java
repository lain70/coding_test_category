package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class NMoveNEWS {
    public static void main(String[] args) {
        String moves = "LRUD";
        int[] mX = new int[]{0,0,-1,1};
        int[] mY = new int[]{-1,1,0,0};

        Scanner sc = new Scanner(System.in);
        
        int n = Integer.valueOf(sc.nextLine());
        
        String[] input = sc.nextLine().split(" ");

        int x = 0;
        int y = 0;
        for(String s : input){
            int nX = x + mX[moves.indexOf(s)];
            int nY = y + mY[moves.indexOf(s)];

            if(nX < 0 || nX >= n || nY < 0 || nY >= n){
                continue;
            }

            x = nX;
            y = nY;
        }

        System.out.println(++x + " " + ++y);
    }
}
