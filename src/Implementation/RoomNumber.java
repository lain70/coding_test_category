package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1475
//각 숫자별 갯수를 기록 하고 가장 많이 사용된 숫자의 갯수가 셋트의 갯수가 된다.
//9,6은 같은 숫자로 보고 2개 사용된 1셋트로 계산한다.
public class RoomNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        n = n.replaceAll("9","6");

        //9는 6으로 보기 때문에 숫자 9는 카운트 하지 않는다.
        int[] number = new int[9];

        String[] arr = n.split("");
        for(String a : arr){
            number[Integer.parseInt(a)] += 1;
        }

        int max = 0;
        for(int i = 0; i < number.length; i++){
            int now = number[i];
            if(i == 6){
                now = (now / 2) + (now%2);
            }
            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}
