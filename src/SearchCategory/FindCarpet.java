package SearchCategory;

public class FindCarpet {
	// yellow 갯수 A는 x*y이다. 모든 x*y = A인 경우를 탐색하면 되는데 y*x는 같은 경우를 고려한다.
	// brown 갯수 B는 2(x+2) + 2y 
	// 위 2개를 만족하는 경우를 찾는다. 카펫의 가로는 max(x + 2, y + 2)
	
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int x = 0;
        int y = 0;
        
        for(int i = 1; i <= (yellow+1)/2; i++) {
        	if(yellow%i == 0) {
        		x=i;
        		y=yellow/i;
        		
        		if(((2 * (x + 2)) + (2 * y)) == brown) {
        			System.out.println("x : " + x + "y : " + y);
        			answer[0] = Math.max(x + 2, y + 2);
        			answer[1] = Math.min(x + 2, y + 2);
        		}
        	}
        }
        return answer;
    }
    
    public static void main(String[] args) {
		FindCarpet fc = new FindCarpet();
		
		System.out.println(fc.solution(8, 1));
	}
}
