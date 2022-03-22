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
		
		int j= 1;
		for(int i = temp.length(); i > 0; i--) {			
			answer += Integer.valueOf(temp.substring(i-1, i)) * j;
			j *= 3;
		}
		
        return answer;
    }
    
    public static void main(String[] args) {
		TernaryBase tb = new TernaryBase();
		System.out.println(tb.solution(125));
//		System.out.println(toTeranary(45));
//		System.out.println(reverse(toTeranary(150)));
				
	}
}
