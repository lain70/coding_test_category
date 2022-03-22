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
		//�ּ� ������ ī�尡 ���� ������ ���ݰ� ���� �� 
		if(price[0][0] == amount) {
			System.out.println(price[0][1]);
			return;
		}
		
		int[] buyCnt = new int [n];
		Arrays.fill(buyCnt, 0);
		
		String answer = "";
		// ��� ī���� ������ ���� ��� �ִ� ���� ������ ī�� ���� * �ִ� ����
		if(price[0][0] == price[price.length - 1][0]) {
			for(int i = 0; i < (amount / price[0][0]); i++ ) {
				answer += (n - 1);
			}
			System.out.println(answer.toString());
			return;
		}
		
		//�ִ��� ���� ī�带 ��� ���� ������ �ڸ����� ���� �� �ִ�. (��, 0 ī�带 ������ �ϳ��� ī�带 �����Ͽ�)
		int cardMinPrice = price[0][0];
		
		//�ּ� ���� ī�� ���� ���� ����
		int zeroCardCnt = amount / cardMinPrice;
		amount = amount % cardMinPrice;
		
		
		//�ּ� ������ ī�尡 0�� �� 0 �̻��� ī�尡 1���� �־�� �Ѵ�.
		if(price[0][1] == 0 && amount == 0) {
			// 0 ī�带 ���� ���� x�� �ִ��̸鼭 ���� �ܾ����� ��� �ִ� ī�� �� ���� ū ���� ī�带 ���Ѵ�.
			boolean noZeroCard = false;
			int maxCard = 0;
			int maxCardPrice = 0;
			for(int i = 1; i < zeroCardCnt; i++) {
				amount = cardMinPrice * i;
				for(int j = n - 1; j > 0; j--) {
					if(amount > price[j][0]) {	//���� ������ ���
						maxCard = Math.max(maxCard, price[j][1]); // 0 ī�� �ִ� ���� ���� �� �� ���� �ܾ����� �� �� �ִ� ���� ū ���� ī��
						maxCardPrice = price[j][0];
						noZeroCard = true;						
					}
				}
				//0�̻��� ī�尡 ���ŵ� ���
				if(noZeroCard) {
					buyCnt[maxCard]++;
					zeroCardCnt -= i;
					amount -= maxCardPrice;					
					break;
				}
			}			
			
		}

		// �ּ� ���� + ���� �ܾ����� �� �� �ִ� �ִ� ������ ī�带 ���Ѵ�.
		for (int i = amount; i > 0; i--) {
			for (int j = n - 1; j > 0; j--) {
				if (zeroCardCnt > 0 && cardMinPrice + i == price[j][0]) { // ���� ������ ���
					zeroCardCnt--; // �ּ� ���� ���� ���� 1�� ����
					buyCnt[price[j][1]]++; // ������ ī�� ���� 1�� ���
					amount -= i; // ���� �ܾ� ����
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
		//�ּ� �������� ������ ī�尡 ������ ���������� ���
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
