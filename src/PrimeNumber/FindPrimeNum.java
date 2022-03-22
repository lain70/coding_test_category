package PrimeNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum {
	public static Set<Integer> set = new HashSet<>();
	public static void dfs(int arr[], int dept, boolean[] visited, int n, int r, String current) {
		if(!"".equals(current)) {
			set.add(Integer.valueOf(current));	
		}
		
		if(dept == r) {			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(arr, dept + 1, visited, n, r, current + String.valueOf(arr[i]));
				visited[i] = false;
			}
		}
		
		
	}
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        Arrays.fill(visited, false);
        int[] arr = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();        
        dfs(arr, 0, visited, arr.length, arr.length, "");
        
        
        int maxNum = Collections.max(set);
        
        boolean[] boolPrimeNum = new boolean[maxNum + 1];
        
        Arrays.fill(boolPrimeNum, true);
        boolPrimeNum[0] = false;
        boolPrimeNum[1] = false;
        
        for(int i = 2; i <= Math.sqrt(maxNum); i++) {
        	
        	if(boolPrimeNum[i] == true) {
        		int j = 2;
        		while(i * j <= maxNum) {
        			boolPrimeNum[i * j] = false;
        			j++;
        		}
        	}        	
        }        
        
        for(Integer a : set) {
        	if(boolPrimeNum[a]) {
        		answer++;
        	}
        }
        
        
        return answer;
    }
    
    public static void main(String[] args) {
		FindPrimeNum fpn = new FindPrimeNum();
		
		System.out.println(fpn.solution("011"));
	}
}
