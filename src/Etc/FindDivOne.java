package Etc;

public class FindDivOne {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= Math.sqrt(n); i++) {
        	if((n-1)%i == 0) {
        		answer = i;
        		break;
        	}
        }
        
        
        return (answer == 0)? (n - 1) : answer;
    }
}
