package SearchCategory;

public class FindCarpet {
	// yellow ���� A�� x*y�̴�. ��� x*y = A�� ��츦 Ž���ϸ� �Ǵµ� y*x�� ���� ��츦 ����Ѵ�.
	// brown ���� B�� 2(x+2) + 2y 
	// �� 2���� �����ϴ� ��츦 ã�´�. ī���� ���δ� max(x + 2, y + 2)
	
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
