package DynamicProgram;

import java.util.Arrays;

public class MakeCoinSum {
	
	public static void main(String[] args) {

		int[] coin = {2,3};
		int target = 15;
		
		Arrays.sort(coin);
		int[] save = new int[target + 1];
		Arrays.fill(save, Integer.MAX_VALUE);
		save[0] = 0;
		for(int i = 0; i < coin.length; i++) {
			for(int j = coin[i]; j <= target; j++) {
				if(save[j - coin[i]] != Integer.MAX_VALUE) {
					save[j] = Math.min(save[j], save[j - coin[i]] + 1); 
				}
			}			
		}
		
		if(save[target] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(save[target]);
		}

	}
}
