package StringTest;

import java.util.Scanner;
import java.util.Stack;

public class StringBomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String basic = sc.nextLine();
        String bomb = sc.nextLine();
        int bombLength = bomb.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < basic.length(); i++){
            stack.push(basic.charAt(i));
            if(stack.size() >= bombLength){
                boolean same = true;
                for(int j = 0; j < bombLength; j++){
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        same = false;
                        break;
                    }
                }
                if(same){
                    for(int j = 0; j < bombLength; j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : stack){
            sb.append(ch);
        }

        System.out.println(sb == null || "".equals(sb.toString())? "FRULA" : sb.toString());
    }
}
