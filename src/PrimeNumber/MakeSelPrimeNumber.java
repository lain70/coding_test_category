package PrimeNumber;

import java.util.Arrays;

public class MakeSelPrimeNumber {
	 public static int answer = 0;
	    public static boolean[] boolPrimeNum;
	    
	    
		public static void combination(int[] arr, int[] ouput, boolean[] visited, int start, int n, int r) {
			
		    if(r == 0) {
		    	System.out.println("Arrays.stream(ouput).sum() : " + Arrays.stream(ouput).sum());
		    	if(boolPrimeNum[Arrays.stream(ouput).sum()]) {
		    		answer++;
		    	}
		        return;
		    } 

		    for(int i=start; i<n; i++) {
		        visited[i] = true;
		        ouput[r-1] = arr[i];
		        combination(arr, ouput, visited, i + 1, n, r - 1);
		        visited[i] = false;
		    }
		}
		
	    public int solution(int[] nums) {
	        
	        Arrays.sort(nums);
	        
	        boolean[] visted = new boolean[nums.length];
	        Arrays.fill(visted, false);
	        
	        int maxNum = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
	        
	        boolPrimeNum = new boolean[maxNum + 1];
	        
	        Arrays.fill(boolPrimeNum, true);
	        
	        for(int i = 2; i <= Math.sqrt(maxNum); i++) {
	        	
	        	if(boolPrimeNum[i] == true) {
	        		int j = 2;
	        		while(i * j <= maxNum) {
	        			boolPrimeNum[i * j] = false;
	        			j++;
	        		}
	        	}        	
	        }        
	        
	        int[] ouput = new int[3];
	        combination(nums, ouput, visted, 0, nums.length, 3);
	        
	        return answer;
	    }
    
    public static void main(String[] args) {
    	MakeSelPrimeNumber msp = new MakeSelPrimeNumber();

    	int[] nums = {1,2,3,4};
    	
    	System.out.println(msp.solution(nums));	
	}
}
