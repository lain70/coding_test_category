package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class FindCroAlphabat {
    public static void main(String[] args) {
        String[] kroAlphabat = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int result = 0;

        for(String ka : kroAlphabat){
            if (input.contains(ka)){
                int preLenght = input.length();
                //포함된 문자열 제거
                String afterInput = input.replaceAll(ka,"");
                //제거된 문자열의 길이
                int afLength = afterInput.length();
                result += (preLenght - afLength) / ka.length();
                input = input.replaceAll(ka,"0");
            }
        }
        result += input.replaceAll("0","").length();


        System.out.println(result);

    }
}
