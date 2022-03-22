package Greed;

import java.util.Arrays;

public class BudgetDiv {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int sum = 0;
        for(int a : d) {
        	sum +=a;
        	if(sum<=budget) {        		
        		answer++;
        	}else {
        		break;
        	}
        	
        }
        return answer;
    }
    
    public static void main(String[] args) {
		BudgetDiv bd = new BudgetDiv();
		
		int[] d = {1,3,2,5,4};
		int budget = 9;
		bd.solution(d, budget);
	}
}
