package Greed;

import java.util.Arrays;
import java.util.Scanner;

//백준 1049
public class ChangeGuitarLine {
	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		
		int[] myGuitar = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] lineSet = new int[myGuitar[1]];
		int[] linePrice = new int[myGuitar[1]];
		// 셋트 가격과 낱개 가격을 따로 저장
		for(int i = 0; i < myGuitar[1]; i++) {
			String[] now = sc.nextLine().split(" ");
			
			lineSet[i] = Integer.valueOf(now[0]);
			linePrice[i] = Integer.valueOf(now[1]);
		}		
		
		Arrays.sort(lineSet);
		Arrays.sort(linePrice);
		
		int setMin = lineSet[0];		// 셋트 살 때 최소 가격
		int priceMin = linePrice[0];	// 1개 살 때 최소 가격
		
		// 낱개로 6개 살 때가 셋트 최소가 보다 작은 경우 낱개로 모든 줄 구입
		if(setMin > priceMin * 6) {
			answer = myGuitar[0] * priceMin;
			System.out.println(answer);
			return;
		}
	
		int noSetMaxPrice = setMin / priceMin;	// 셋트 구매보다 낱개 구매가 이득인 최대 갯수
		
		// 줄이 6개 이상인 경우 셋트 최소가로 구매
		if(myGuitar[0] > 6) {
			answer += (myGuitar[0] / 6) * setMin; 
		}
		
		// 줄이 6개 셋트가 안되는 경우 남은 줄을 낱개로 구매시 셋트 보다 싼지 비교
		if(myGuitar[0] % 6 > noSetMaxPrice) {	// 남은 줄이 6개가 안되지만 셋트 구매가 싼 경우
			answer += setMin;
		}else {	// 남은 줄을 낱개로 사는 경우가 싼 경우
			answer += (myGuitar[0] % 6) * priceMin;
		}
		
		System.out.println(answer);
	}
}
