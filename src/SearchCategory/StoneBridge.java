package SearchCategory;

public class StoneBridge {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int l = 0;
        int r = distance;
        answer = distance;
        int maxGrp = rocks.length + 1 - n;
        while(l <= r) {
			int mid = l + (r - l) / 2;
			int sum = 0;
			int numGroup = 1;
			int maxSum = 0; 
			for(int i = 0; i < rocks.length; i++) {
				if(sum + rocks[i] > mid) {
					maxSum = Math.max(sum, maxSum);
					int preRock = (i == 0)?0:rocks[i-1];
					sum = rocks[i] - preRock;
					numGroup++;
				}else {
					int preRock = (i == 0)?0:rocks[i-1];
					sum += rocks[i] - preRock;
				}
				
				maxSum = Math.max(sum, maxSum);
				if(numGroup > maxGrp) {
					l = mid + 1;
				} else {
					Math.min(maxSum, answer);
					r = mid - 1;
				}
			}
        }
        
        return answer;
    }
}
