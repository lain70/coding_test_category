package Etc;

public class TernaryBase {
	public static int toTeranary(int tenBase) {
		String answer = "";
		String temp = "";
		while(tenBase != 0) {
			System.out.println(tenBase%3);
			temp += String.valueOf(tenBase%3);
			tenBase /= 3;
		}
		
		for(String a : temp.split("")) {
			answer = a + answer;
		}
		return Integer.valueOf(answer);
	}
	
	public static int reverse(int num) {
		String temp = "";
		for(String a : String.valueOf(num).split("")) {
			temp = a + temp;
		}
		return Integer.valueOf(temp);
	}
	
    public int solution(int n) {
        int answer = 0;
        String temp = "";
		while(n != 0) {
			temp += String.valueOf(n%3);
			n /= 3;
		}
		temp = String.valueOf(Integer.valueOf(temp));
		
		String now ="";
		for(String a : temp.split("")) {
			now = a + now;
		}
		
		int k = 1;
		for(String a : now.split("")) {
			answer += k * Integer.valueOf(a);
			k *= 3;
		}
		
        return answer;
    }
    
    public static void main(String[] args) {
		TernaryBase tb = new TernaryBase();
		tb.solution(45);
//		System.out.println(toTeranary(45));
//		System.out.println(reverse(toTeranary(150)));
				
	}
}
