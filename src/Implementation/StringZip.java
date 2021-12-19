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
				if (j == 0) {//최초 문자 패턴 초기화
					tempString = s.substring(j * i, (j * i) + i);
					continue;
				}

				if (tempString.equals(s.substring(j * i, (j * i) + i))) {	//문자열이 같은 경우 횟수 증가
					tempStringCnt++;
				} else {
					if (tempStringCnt > 1) {	// 문자열이 다른데 같은 경우가 반복된 경우
						tempMinimumSize += i + String.valueOf(tempStringCnt).length();	// + 패턴 문자열 길이 + 횟수를 문자열로 봤을 때 길이 더하기
					} else {
						tempMinimumSize += i;	// +패턴 문자열 길이
					}
					tempString = s.substring(j * i, (j * i) + i);	//문자 패턴 변경
					tempStringCnt = 1;	//반복횟수 1로 초기화
				}

				if ((j == (s.length() / i) - 1)) {	// 다음 문자열 패턴이 없는 경우
					if (tempStringCnt > 1) {
						tempMinimumSize += i + String.valueOf(tempStringCnt).length();
					} else {
						tempMinimumSize += i;
					}
				}
			}

			if (s.length() % i > 0) {	//문자열을 i만큼 반복할 때 왼쪽에 i보다 작아서 패턴을 형성 못하는 경우 더해줌
				tempMinimumSize += s.length() % i;
			}

			if (answer > tempMinimumSize) {	//기존보다 신규 크기가 작은 경우 교체
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
