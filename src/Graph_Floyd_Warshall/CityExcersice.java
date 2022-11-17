package Graph_Floyd_Warshall;

import java.util.Arrays;
import java.util.Scanner;


//백준 1956
//V개의 마을와 E개의 도로로 구성되어 있는 도시가 있다. 도로는 마을과 마을 사이에 놓여 있으며, 일방 통행 도로이다. 마을에는 편의상 1번부터 V번까지 번호가 매겨져 있다고 하자.
//당신은 도로를 따라 운동을 하기 위한 경로를 찾으려고 한다. 운동을 한 후에는 다시 시작점으로 돌아오는 것이 좋기 때문에, 우리는 사이클을 찾기를 원한다. 단, 당신은 운동을 매우 귀찮아하므로, 사이클을 이루는 도로의 길이의 합이 최소가 되도록 찾으려고 한다.
//도로의 정보가 주어졌을 때, 도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성하시오. 두 마을을 왕복하는 경우도 사이클에 포함됨에 주의한다.
public class CityExcersice {

	public static void main(String[] args) {
		int max = 4000001;
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		
		int v = Integer.valueOf(input[0]);
		int e = Integer.valueOf(input[1]);
		
		int[][] map = new int[v+1][v+1];
		for(int[] m : map) {
			Arrays.fill(m, max);
		}
		
		for(int i = 0; i < e; i++) {
			String[] info = sc.nextLine().split(" ");
			map[Integer.valueOf(info[0])][Integer.valueOf(info[1])] = Integer.valueOf(info[2]);
		}
		
		for(int k = 1; k <= v; k++) {
			for(int a = 1; a <= v; a++) {
				for(int b = 1; b <= v; b++) {					
					if(map[a][b] > map[a][k] + map[k][b]) {
						map[a][b] = map[a][k] + map[k][b];
					}
				}
			}
		}
		
		int answer = max;
		for(int i = 1; i <= v; i++) {
			answer = Math.min(answer, map[i][i]);
		}
		
		if(answer == max) {
			answer= -1;
		}
		System.out.println(answer);
	}
}
