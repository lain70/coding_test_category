package SortCategory;

import java.util.Arrays;
import java.util.Comparator;

public class MakeBigNum {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        int i = 0;
        for(int n : numbers) {
        	str[i] = String.valueOf(n);
        	i++;
        }
        
        Arrays.sort(str, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
        	
        });
        
        if("0".equals(str[0])) return "0";
        
        answer = String.join("", str);
        
        return answer;
    }
    
    public static void main(String[] args) {
		MakeBigNum mbn = new MakeBigNum();
		
        String[] test = new String[] {"6102", "6210", "1062", "1026", "2610", "2106"};
        mbn.solution(new int[] {6,10,2});
        
//        Arrays.sort(test);
//        
//        for(String a : test) {
//        	System.out.println(a);
//        }
	}
}
