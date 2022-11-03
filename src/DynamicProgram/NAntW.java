package DynamicProgram;

import java.util.Arrays;
import java.util.Scanner;

public class NAntW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] stock = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] save = new int[n];
        Arrays.fill(save, 0);

        save[0] = stock[0];
        save[1] = stock[1];

        for(int i = 2; i < n; i++){
            save[i] = Math.max(stock[i] + save[i - 2], save[i - 1]);
        }

        System.out.println(save[n-1]);
    }
}
