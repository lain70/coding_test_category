package Greed;

import java.util.Arrays;

public class MakeBigNum {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strArr = new String[numbers.length];
        
        int i = 0;
        for(int n : numbers) {
        	strArr[i] = String.valueOf(n);
        	i++;
        }
        
        Arrays.sort(strArr);
        
        for(int j = strArr.length-1; j >=0; j--) {
        	answer += strArr[j];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		MakeBigNum mbn = new MakeBigNum();
		System.out.println(mbn.solution(new int[] {3,30,34,315,5,9}));
	}
}
