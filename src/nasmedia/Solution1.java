package nasmedia;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        String str = "qyyigoptvfb";
        Queue<Character> que = new LinkedList<>();

        int ro = 3;
        if(ro < 0){
            str = new StringBuilder(str).reverse().toString();
        }

        for(int i = 0; i < str.length(); i++){
            que.offer(str.charAt(i));
        }

        for(int i = 0; i < ro; i++){
            char rot = que.poll();
            que.offer(rot);
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            sb.append(que.poll());
        }

        String preRotation = ro < 0 ? sb.reverse().toString():sb.toString();

        System.out.println(decrypt(preRotation, "abcdefghijk"));
    }

    static String crypt(String text, String key){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int cryptChar = text.charAt(i) + (key.charAt(i) - 96);
            if(cryptChar > 122){
                cryptChar = cryptChar - 122 + 96;
            }
            sb.append((char)cryptChar);
        }

        return sb.toString();
    }

    static String decrypt(String text, String key){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int decryptChar = text.charAt(i) - (key.charAt(i) - 96);
            if(decryptChar < 97){
                decryptChar = 123 - (97 - decryptChar);
            }
            sb.append((char)decryptChar);
        }

        return sb.toString();
    }
}
