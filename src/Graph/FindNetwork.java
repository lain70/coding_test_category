package Graph;

public class FindNetwork {
	
	public static void dfs(int[][] computers, boolean[] visited, int start) {
		visited[start] = true;
		
		for(int j = 0; j < computers.length; j++) {
			if(start !=j && computers[start][j] == 1 && !visited[j]) {				
				dfs(computers, visited, j);				
			}
		}
	}

    public int solution(int n, int[][] computers) {
    	int answer = 0;    
        boolean[] visited = new boolean[n];
        
        
        for(int i = 0; i < n; i++) {
        	if(!visited[i]) {
        		dfs(computers, visited, i);	
        		answer++;
        	}
        	
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		FindNetwork fn = new FindNetwork();
		System.out.println(fn.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
}
