package Greed;

import java.util.LinkedList;
import java.util.Queue;

public class CalMax {
	public static long numberCal(String express, long a, long b) {
		switch (express) {
		case "*":
			return a * b;
		case "-":
			return a - b;
		default:
			return a + b;
		}

	}

	public long solution(String expression) {
		long answer = 0;
		// 6개만 나오는게 고정된 상황에서 구지 순열을 써서 구하면 자원 낭비가 아닐까 . .
		String[] cal = { "+-*", "+*-", "-+*", "-*+", "*+-", "*-+" };

		Queue<String> mainQue = new LinkedList<String>();

		StringBuilder sb = new StringBuilder();
		for (String a : expression.split("")) {
			if ("+-*".contains(a)) { // 수식을 만나면 que에 삽입
				mainQue.offer(sb.toString());
				sb = new StringBuilder();
				mainQue.offer(String.valueOf(a));
			} else {
				sb.append(a);
			}
		}

		mainQue.offer(sb.toString()); // 마지막 숫자를 넣어준다.

		Queue<String> que = new LinkedList<String>();
		for (String c : cal) {
			que.addAll(mainQue);

			for (String d : c.split("")) {
				if (!expression.contains(d)) { // 계산식이 문자열에 없는 경우
					continue;
				}

				
				Queue<String> subQue = new LinkedList<String>();
				long preNum = Long.valueOf(que.poll());	//최초 숫자 설정
				while (!que.isEmpty()) { // 최초로 앞에 숫자를 설정한 이후 계산식을 만나면 계산 또는 그 다음 숫자를 앞에 숫자로 설정하기 때문에 계속 수식을 만나게 된다.
					String str = que.poll();

					if (d.equals(str)) { // 현재 계산해야하는 수식인 경우
						preNum = numberCal(str, preNum, Long.valueOf(que.poll())); // 계산하여 preNum에
					} else { // 현재 계산해야하는 경우가 아니면 이전 수와 수식을 하위 큐에 넣고 preNum은 다음 수로
						subQue.offer(String.valueOf(preNum));
						subQue.offer(str);
						preNum = Long.valueOf(que.poll());
					}

					if (que.isEmpty()) {
						subQue.offer(String.valueOf(preNum));
					}
				}
				que = subQue; // 현재 계산된 내용을 다음 계산을 위해 que로
			}

			answer = Math.max(Math.abs(Long.valueOf(que.poll())), answer); // 더큰 값을 결과 값으로
		}

		return answer;
	}

	public static void main(String[] args) {
		CalMax cm = new CalMax();

		System.out.println(cm.solution("50*6-3*2"));
	}
}
