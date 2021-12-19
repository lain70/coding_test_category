package Implementation;

public class StringZip {
	public int solution(String s) {
int answer = s.length();
		
		int halfSize = 0;
		if (s != null && !"".equals(s) && s.length() > 0) {
			halfSize = s.length() / 2;
		}		

		for (int i = 1; i <= halfSize; i++) {

			String tempString = "";
			int tempStringCnt = 1;
			int tempMinimumSize = 0;
			for (int j = 0; j < s.length() / i; j++) {
				if (j == 0) {//���� ���� ���� �ʱ�ȭ
					tempString = s.substring(j * i, (j * i) + i);
					continue;
				}

				if (tempString.equals(s.substring(j * i, (j * i) + i))) {	//���ڿ��� ���� ��� Ƚ�� ����
					tempStringCnt++;
				} else {
					if (tempStringCnt > 1) {	// ���ڿ��� �ٸ��� ���� ��찡 �ݺ��� ���
						tempMinimumSize += i + String.valueOf(tempStringCnt).length();	// + ���� ���ڿ� ���� + Ƚ���� ���ڿ��� ���� �� ���� ���ϱ�
					} else {
						tempMinimumSize += i;	// +���� ���ڿ� ����
					}
					tempString = s.substring(j * i, (j * i) + i);	//���� ���� ����
					tempStringCnt = 1;	//�ݺ�Ƚ�� 1�� �ʱ�ȭ
				}

				if ((j == (s.length() / i) - 1)) {	// ���� ���ڿ� ������ ���� ���
					if (tempStringCnt > 1) {
						tempMinimumSize += i + String.valueOf(tempStringCnt).length();
					} else {
						tempMinimumSize += i;
					}
				}
			}

			if (s.length() % i > 0) {	//���ڿ��� i��ŭ �ݺ��� �� ���ʿ� i���� �۾Ƽ� ������ ���� ���ϴ� ��� ������
				tempMinimumSize += s.length() % i;
			}

			if (answer > tempMinimumSize) {	//�������� �ű� ũ�Ⱑ ���� ��� ��ü
				answer = tempMinimumSize;
			}

		}

		return answer;
	}
	
	public static void main(String[] args) {
		StringZip sz = new StringZip();
		
		System.out.println(sz.solution("aabbaccc"));
	}
}
