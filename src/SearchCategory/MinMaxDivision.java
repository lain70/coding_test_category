package SearchCategory;

import java.util.Arrays;

//Codility Lesson14-1
public class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
		// write your code in Java SE 8
		int l = 0;
		int r = M * A.length;
		int ans = M * A.length;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int sum = 0;
			int numGroup = 1;
			int maxSum = 0;
			for (int i = 0; i < A.length; i++) {
				if (sum + A[i] > mid) {
					maxSum = Math.max(sum, maxSum);
					sum = A[i];
					numGroup++;
				} else {
					sum += A[i];
				}
			}
			maxSum = Math.max(sum, maxSum);
			if (numGroup > K) {
				l = mid + 1;
			} else {
				ans = Math.min(maxSum, ans);
				r = mid - 1;
			}
		}
		return ans;
    }
}
