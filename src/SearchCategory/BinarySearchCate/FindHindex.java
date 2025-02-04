package SearchCategory.BinarySearchCate;

import java.util.Arrays;

public class FindHindex {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int start = citations[0];
        int end = citations[citations.length-1];
        
        while(start <= end) {
        	int mid = (start + end) / 2;
        	
        	int h = 0;
        	for(int i = 0; i < citations.length - 1; i++) {
        		if(mid <= citations[i]) {
        			h = citations.length - i;
        			break;
        		}
        	}
        	
        	if(h == 0) {
        		answer = 0;
        		break;
        	}
        	
        	if(start == mid || end == mid) {
        		return mid;
        	}
        	
        	if(h == mid) {
        		answer = mid;
        		break;
        	}else if(h>mid) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        	
        }        
        
        return answer;
    }
    
    public static void main(String[] args) {
		FindHindex fh = new FindHindex();
		System.out.println(fh.solution(new int[] {3, 0, 6, 1, 5}));
	}
}
