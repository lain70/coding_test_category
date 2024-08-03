package StringTest;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++){
            strArr[i] = sc.nextLine();
        }

        for(String str : strArr){
            char[] charArr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean result = true;
            for(char ch : charArr){
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()){
                       result = false;
                    }else {
                        stack.pop();
                    }
                }
            }
            System.out.println((stack.isEmpty() && result) ? "YES" : "NO");
        }
    }
}
