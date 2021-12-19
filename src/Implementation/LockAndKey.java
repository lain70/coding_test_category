package Implementation;

public class LockAndKey {
	
	public int[][] rotate(int[][]arr, int degree){
		int m = arr.length;
		int n = arr[0].length;
		int rotate[][] = arr;
		for (int i = 0; i < rotate.length; i++) {
	        for (int j = 0; j < rotate[i].length; j++) {
	            switch (degree) {
	                case 90:
	                    rotate[i][j] = arr[n-1-j][i];
	                    break;
	                case 180:
	                    rotate[i][j] = arr[n-1-i][m-1-j];
	                    break;
	                case 270:
	                    rotate[i][j] = arr[j][m-1-i];
	                    break;
	            }
	        }
	    }
		
		return rotate;
	}
	
	public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        return answer;
    }
}
