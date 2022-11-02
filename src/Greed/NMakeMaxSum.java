package Greed;

import java.util.Arrays;
import java.util.Scanner;

public class NMakeMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nm = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] cards = new int[nm[0]][nm[1]];

        for(int i = 0; i < cards.length; i++){
            cards[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int max = 0;
        for(int i = 0; i < cards.length; i++){
            Arrays.sort(cards[i]);
            max = Math.max(max, cards[i][0]);
        }

        System.out.println(max);
    }
}
