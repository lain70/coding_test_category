package Dfs_Bfs;

public class TargetNumber {
    
    public static int search(int[] numbers, int target, int depth,  int sum){
    	
        if(numbers.length - 1 == depth){
        	
            if(sum == target){
            	return 1;
            }
            return 0;
            
        }        
        
        int answer = 0;
        answer += search(numbers, target, depth + 1, sum + numbers[depth + 1]);
        answer += search(numbers, target, depth + 1, sum - numbers[depth + 1]);
        
        return answer;

    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer += search(numbers, target, 0, numbers[0]);
        answer += search(numbers, target, 0, -numbers[0]);

        return answer;
    }
    
    public static void main(String[] args) {
		TargetNumber tn = new TargetNumber();
		
		int[] numbers = {1, 1, 1 ,1 ,1};
		int target = 3;
		
		System.out.println(tn.solution(numbers, target));
	}
}
