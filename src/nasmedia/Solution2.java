package nasmedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        String t = "tesd";
        System.out.println(t.substring(0,t.indexOf("e"))+t.substring(t.indexOf("e")+1));

        String[] card = new String[3];
        String[] word = new String[]{};

        List<String> resultList = new ArrayList<>();

        boolean[] find = new boolean[3];
        for(String wd : word){
            Arrays.fill(find, false);
            String[] checkWord = word.clone();
            for(int i = 0; i < wd.length(); i++){
                for(int j = 0; j < checkWord.length; j++){
                    int idx = checkWord[j].indexOf(String.valueOf(wd.charAt(i)));
                    if (idx > 0) {
                        find[j] = true;
                        checkWord[j] = checkWord[j].substring(0, idx) + checkWord[j].substring(idx + 1);
                        break;
                    }
                }
            }

            boolean possible = true;
            for(boolean f : find){
                possible = f;
            }

            if(possible) resultList.add(wd);
        }

//        if(resultList.size() < 1){
//            return "-1";
//        }else{
//
//        }
    }
}
