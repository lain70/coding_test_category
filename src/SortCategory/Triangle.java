package SortCategory;

import java.util.Arrays;

// 코딜리티 sort triangle
// 3개의 수 중에서 가장 큰수에 한개의 수를 더하면 무조건 나머지보다 클 수 밖에 없다.
// 그러므로 가장 큰 수가 나머지 2개의 수의 함보다 작은 조건인 경우만 찾으면 된다.
// 배열을 정렬 후에 현재 선택된 수 보다 작은 2개의 수의 합을 현재 수와 비교하여 현재 수보다 크면 조건 만족 
// 현재 수 보다 작은 수 중 2개의 수를 선택할 때 현재 수 다음으로 큰 2개의 수의 합보다 큰 경우는 없으므로
// 현재 수 다음으로 큰 2개의 수가 현재의 수 보다 크지 않다면 어떠한 수를 2개 선택해도 현재 수보다 클 수 는 없다.
// 그러므로 A[i] < A[i-1] + A[i-2]를 만족하는 경우를 찾는다.
public class Triangle {
    public int solution(int[] A) {
    	int answer = 0;
    	Arrays.sort(A);
    	
    	
    	for(int i = 2; i<A.length; i++) {
    		if(Long.valueOf(A[i]) < Long.valueOf(A[i-1]) + Long.valueOf(A[i-2])) {
    			answer = 1;
    			break;
    		}
    	}
    	
    	return answer;    	
    }
}
