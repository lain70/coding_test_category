package Etc;

public class DivisorNum {
	
	public static int calDiv(int num) {
		// num의 제곱근이 약수이냐 아니냐에 따라 짝수 홀수가 나뉜다.
		int result = 0;
		for(int i = 1; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				result++;
			}
		}
		return result;
	}
	
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
        	//제곱근이 정수이냐 아니냐에 따라 홀수 짝수로 나뉜다.
        	if(Math.sqrt(16) % 1 > 0) {
        		answer += i;
        	}else {
        		answer -= i;
        	}
        }
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(Math.sqrt(16) % 1 > 0);
	}
}
