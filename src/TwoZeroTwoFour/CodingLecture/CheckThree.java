package TwoZeroTwoFour.CodingLecture;

import java.util.Scanner;

public class CheckThree {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());

        int cnt = 0;
        for(int i = 0; i < n+1; i++){
            if(String.valueOf(i).contains("3")){
                cnt += 60 * 60;
                continue;
            }
            for(int j = 0; j < 60; j++){
                if(String.valueOf(j).contains("3")){
                    cnt += 60;
                    continue;
                }
                for(int k = 0; k < 60; k++){
                    if(String.valueOf(k).contains("3")){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
