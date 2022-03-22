package Implementation;

import java.util.ArrayList;
import java.util.List;

public class ChickenDelivery {

	public static void main(String[] args) {
		
//		int[][] city = new int[][] {{0,0,1,0,0},{0,0,2,0,1},{0,1,2,0,0},{0,0,1,0,0},{0,0,0,0,2}};
		int[][] city = new int[][] {{0,2,0,1,0},{1,0,1,0,0},{0,0,0,0,0},{2,0,0,1,1},{2,2,0,1,2}};
		
		List<int[]> houseList = new ArrayList<>();
		List<int[]> chickenList = new ArrayList<>();
		
		for(int i = 0; i < city.length; i++) {
			for(int j = 0; j < city[0].length; j++) {
				if(city[i][j] == 1) {
					int[] nowH = new int[2];
					nowH[0] = i;
					nowH[1] = j;
					houseList.add(nowH);
				}else if(city[i][j] == 2) {
					int[] nowC = new int[2];
					nowC[0] = i;
					nowC[1] = j;
					chickenList.add(nowC);
				}
			}			
		}
		
		int result = 0;
		for(int i = 0; i < houseList.size(); i++) {
			int min = 251;
			for(int j = 0; j < chickenList.size(); j++) {
				int nowDistance = Math.abs(houseList.get(i)[0] - chickenList.get(j)[0]) + Math.abs(houseList.get(i)[1] - chickenList.get(j)[1]);
				min = Math.min(min, nowDistance);
			}
			result += min;
		}
		
		System.out.println(result);
		
	}
}
