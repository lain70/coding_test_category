package Greed_Graph;
import java.util.Scanner;

// น้มุ 11403
public class FindLoad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		int[][] arr = new int[n][n];
		
		for(int i = 0 ; i < n; i++) {
			String[] input = sc.nextLine().split(" ");
			for(int j = 0 ; j < n; j++) {				
				arr[i][j] = Integer.valueOf(input[j]);				
			}
		}
		
		//N(i,j) = N(Nik -> Nkj)
		for(int k = 0 ; k < n; k++) {
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j < n; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for(int i = 0 ; i < n; i++) {			
			for(int j = 0 ; j < n; j++) {
				if(j != n-1) {
					System.out.print(arr[i][j] + " ");	
				}else {
					System.out.print(arr[i][j]);
				}				
			}
			System.out.println("");
		}
			
		
	}
}
