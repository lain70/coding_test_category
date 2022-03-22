package Greed;

import java.util.Arrays;
import java.util.Scanner;

//���� 1049
public class ChangeGuitarLine {
	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		
		int[] myGuitar = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] lineSet = new int[myGuitar[1]];
		int[] linePrice = new int[myGuitar[1]];
		// ��Ʈ ���ݰ� ���� ������ ���� ����
		for(int i = 0; i < myGuitar[1]; i++) {
			String[] now = sc.nextLine().split(" ");
			
			lineSet[i] = Integer.valueOf(now[0]);
			linePrice[i] = Integer.valueOf(now[1]);
		}		
		
		Arrays.sort(lineSet);
		Arrays.sort(linePrice);
		
		int setMin = lineSet[0];		// ��Ʈ �� �� �ּ� ����
		int priceMin = linePrice[0];	// 1�� �� �� �ּ� ����
		
		// ������ 6�� �� ���� ��Ʈ �ּҰ� ���� ���� ��� ������ ��� �� ����
		if(setMin > priceMin * 6) {
			answer = myGuitar[0] * priceMin;
			System.out.println(answer);
			return;
		}
	
		int noSetMaxPrice = setMin / priceMin;	// ��Ʈ ���ź��� ���� ���Ű� �̵��� �ִ� ����
		
		// ���� 6�� �̻��� ��� ��Ʈ �ּҰ��� ����
		if(myGuitar[0] > 6) {
			answer += (myGuitar[0] / 6) * setMin; 
		}
		
		// ���� 6�� ��Ʈ�� �ȵǴ� ��� ���� ���� ������ ���Ž� ��Ʈ ���� ���� ��
		if(myGuitar[0] % 6 > noSetMaxPrice) {	// ���� ���� 6���� �ȵ����� ��Ʈ ���Ű� �� ���
			answer += setMin;
		}else {	// ���� ���� ������ ��� ��찡 �� ���
			answer += (myGuitar[0] % 6) * priceMin;
		}
		
		System.out.println(answer);
	}
}
