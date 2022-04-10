package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//�־��� �װ����� ��� �̿��Ͽ� �����θ� ¥���� �մϴ�. �׻� "ICN" ���׿��� ����մϴ�.
//
//�װ��� ������ ��� 2���� �迭 tickets�� �Ű������� �־��� ��, �湮�ϴ� ���� ��θ� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
//
//���ѻ���
//��� ������ ���ĺ� �빮�� 3���ڷ� �̷�����ϴ�.
//�־��� ���� ���� 3�� �̻� 10,000�� �����Դϴ�.
//tickets�� �� �� [a, b]�� a ���׿��� b �������� ���� �װ����� �ִٴ� �ǹ��Դϴ�.
//�־��� �װ����� ��� ����ؾ� �մϴ�.
//���� ������ ��ΰ� 2�� �̻��� ��� ���ĺ� ������ �ռ��� ��θ� return �մϴ�.
//��� ���ø� �湮�� �� ���� ���� �־����� �ʽ��ϴ�.
//����� ��
//tickets	return
//[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
//����� �� ����
//���� #1
//
//["ICN", "JFK", "HND", "IAD"] ������ �湮�� �� �ֽ��ϴ�.
//
//���� #2
//
//["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] ������ �湮�� ���� ������ ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] �� ���ĺ� ������ �ռ��ϴ�.

//��� ���̽��� ���Ƽ� ������ ��쿡 ���� ã�´�.
public class AirplaneTravle {
	public static List<String> answer = new ArrayList<>();
	public static boolean[] visited;

	public static void dfs(String[][] tickets, int depth, String now,  String next) {
		if (depth == tickets.length) {
			answer.add(now);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && next.equals(tickets[i][0])) {
				visited[i] = true;

				dfs(tickets, depth + 1, now + " " + tickets[i][1], tickets[i][1]);
				visited[i] = false;
			}
		}

	}

	public String[] solution(String[][] tickets) {
		Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return o1[1].compareToIgnoreCase(o2[1]);
			}
		});

		visited = new boolean[tickets.length];
		Arrays.fill(visited, false);

		dfs(tickets, 0, "ICN", "ICN");
		
		return answer.get(0).split(" ");
	}

	public static void main(String[] args) {
		AirplaneTravle at = new AirplaneTravle();
		String[] ans = at.solution(new String[][]  {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
		for(String a : ans) {
			System.out.println(a);
		}


	}
}
