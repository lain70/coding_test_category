package Dfs_Bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//순열 문제
public class PoketmonSel {
	
	public void select() {
		
	}
	
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int a : nums) {
        	set.add(a);
        }
        
        if(set.size() < nums.length / 2 ) {
        	answer = set.size();
        }else {
        	answer = nums.length / 2;
        }
        return answer;
    }

}
