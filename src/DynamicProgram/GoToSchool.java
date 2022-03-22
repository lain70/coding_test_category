package DynamicProgram;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//������ �б� ���� ������ ���� �ִٰ� �Ѵٸ�
//(1,1) -> (m,n) ���� �ּ� �̵��Ÿ��� (m-1) + (n-1)

public class GoToSchool {
	
	public int solution(int m, int n, int[][] puddles) {		
		if(m == 1 && n ==1) {
			return 0;
		}
        int answer = 0;
        
        //�湮���� ���� ���� falseó��
        int[][] visited = new int[m + 1][n + 1];
        for(int[] a : visited) {
        	Arrays.fill(a, 100001);
        }
        
        //�����̴� �湮 ó��
        if(puddles.length > 0) {
        	for(int[] puddle: puddles) {
            	visited[puddle[0]][puddle[1]] = 0;
            }	
        }
        
        
        int[] x = {1,0};
        int[] y = {0,1};
        
        Queue<int[]> que = new LinkedList<int[]>();
        
        que.offer(new int[] {1,1});
        visited[1][1] = 0;
        
        while(!que.isEmpty()) {
        	int[] now = que.poll();
        	
        	int a = now[0];
        	int b = now[1];
        	System.out.println("a : " + a + " / b : " + b + " / visited[a][b] : " + visited[a][b]);
        	
        	for(int i = 0; i < 2; i++) {
        		if(a+x[i] > m || b+y[i] > n) {
        			continue;
        		}
        		
        		if(a+x[i] == m && b+y[i] == n) {   			
        			answer = answer % 1000000007 + 1;
        			continue;
        		}
        		
        		if(visited[a+x[i]][b+y[i]] == 0 || (visited[a][b] + 1) > visited[a+x[i]][b+y[i]]) {
        			continue;
        		}
        		
        		visited[a+x[i]][b+y[i]] = visited[a][b] + 1;        		
        		
        		int[] next = new int[2];
        		next[0] = a+x[i];
        		next[1] = b+y[i];
        		que.offer(next);
        		
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		GoToSchool gts = new GoToSchool();
		System.out.println(gts.solution(4, 3, new int[][] {{2,2}}));
	}
}
