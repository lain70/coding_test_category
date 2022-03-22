package Greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MakeRoomNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		String[] priceStr = sc.nextLine().split(" ");
		Integer[][] price = new Integer[n][2];
		
		for(int i = 0; i < n; i++) {
			price[i][0] = Integer.valueOf(priceStr[i]);
			price[i][1] = i;
		}
		
		Arrays.sort(price, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[0] == o2[0] ) {
					return Integer.compare(o2[1], o1[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		int amount = Integer.valueOf(sc.nextLine());
		//최소 가격의 카드가 구매 가능한 가격과 같을 때 
		if(price[0][0] == amount) {
			System.out.println(price[0][1]);
			return;
		}
		
		int[] buyCnt = new int [n];
		Arrays.fill(buyCnt, 0);
		
		String answer = "";
		// 모든 카드의 가격이 같을 경우 최대 구매 가능한 카드 갯수 * 최대 숫자
		if(price[0][0] == price[price.length - 1][0]) {
			for(int i = 0; i < (amount / price[0][0]); i++ ) {
				answer += (n - 1);
			}
			System.out.println(answer.toString());
			return;
		}
		
		//최대한 많은 카드를 사는 것이 숫자의 자릿수를 높일 수 있다. (단, 0 카드를 제외한 하나의 카드를 포함하여)
		int cardMinPrice = price[0][0];
		
		//최소 가격 카드 구매 가능 갯수
		int zeroCardCnt = amount / cardMinPrice;
		amount = amount % cardMinPrice;
		
		
		//최소 가격의 카드가 0일 때 0 이상의 카드가 1개는 있어야 한다.
		if(price[0][1] == 0 && amount == 0) {
			// 0 카드를 구매 갯수 x가 최대이면서 남은 잔액으로 살수 있는 카드 중 가장 큰 수의 카드를 구한다.
			boolean noZeroCard = false;
			int maxCard = 0;
			int maxCardPrice = 0;
			for(int i = 1; i < zeroCardCnt; i++) {
				amount = cardMinPrice * i;
				for(int j = n - 1; j > 0; j--) {
					if(amount > price[j][0]) {	//구매 가능한 경우
						maxCard = Math.max(maxCard, price[j][1]); // 0 카드 최대 구매 개수 일 때 남은 잔액으로 살 수 있는 가장 큰 수의 카드
						maxCardPrice = price[j][0];
						noZeroCard = true;						
					}
				}
				//0이상의 카드가 구매된 경우
				if(noZeroCard) {
					buyCnt[maxCard]++;
					zeroCardCnt -= i;
					amount -= maxCardPrice;					
					break;
				}
			}			
			
		}

		// 최소 가격 + 남은 잔액으로 살 수 있는 최대 가격의 카드를 구한다.
		for (int i = amount; i > 0; i--) {
			for (int j = n - 1; j > 0; j--) {
				if (zeroCardCnt > 0 && cardMinPrice + i == price[j][0]) { // 구매 가능한 경우
					zeroCardCnt--; // 최소 가격 구매 갯수 1개 감소
					buyCnt[price[j][1]]++; // 구매한 카드 갯수 1개 기록
					amount -= i; // 남은 잔액 감소
					i = amount;
				}

				if (zeroCardCnt == 0) {
					break;
				}
			}

			if (zeroCardCnt == 0) {
				break;
			}
		}
		//최소 가격으로 구매한 카드가 있으면 구매했으면 기록
		if(zeroCardCnt > 0) {
			buyCnt[price[0][1]] = zeroCardCnt;
		}
		
		for(int i = buyCnt.length - 1; i >= 0; i--) {
			if(buyCnt[i] > 0) {
				if(i == 0 && "".equals(answer)) {
					answer = "0";
					break;
				}
				
				for(int j = 0; j < buyCnt[i]; j++) {
					answer += i;
				}
			}
		}
		
		System.out.println(answer);		
	}
}
