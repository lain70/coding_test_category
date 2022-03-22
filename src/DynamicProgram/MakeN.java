package DynamicProgram;

import java.util.Arrays;

public class MakeN {
	public static int result = Integer.MAX_VALUE;
	
	public static int[] minimum = new int[99999999+1];
	
	public static void dfs(int depth, int N, int number, int current) {
		if(depth > 8 || depth >= minimum[current]) {
			return;
		}
		
		minimum[current] = depth;
		
		
		if(number == current) {
			result = Math.min(depth, result);			
		}
		
		int temp = 0;
		
		for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                temp = temp * 10 + N;
                dfs(depth + i + 1, N, number, current + temp);
                if(current - temp > 0) {
                	dfs(depth + i + 1, N, number, current - temp);	
                }
                if(current % temp == 0) {
                dfs(depth + i + 1, N, number, current / temp);
                }
                dfs(depth + i + 1, N, number, current * temp);     
            }      
        }
	}
	
	public int solution(int N, int number) {
		Arrays.fill(minimum, Integer.MAX_VALUE);
		dfs(0, N, number, 0);
		return (result == Integer.MAX_VALUE)?-1:result;
       
    }
    
    public static void main(String[] args) {
		MakeN mn = new MakeN();
		
		System.out.println(mn.solution(5, 5));
	}
}
