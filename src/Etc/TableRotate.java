package Etc;

public class TableRotate {
	
	public static int[][] table;
	
	public int rotate(int[] query) {
		int minimum = table.length * table[0].length + 1;
		
		//table[q[0]][q[1]] -> table[q[0]][q[3]]
		int next = 0;
		int swap = 0;
		for(int i = query[1] - 1; i < query[3]; i++) {
			swap = table[query[0] - 1][i];
			table[query[0] - 1][i] = next;
			next = swap;		
			
			minimum = Math.min(minimum, next);
		}
		
		//table[q[0]+1][q[3]] -> table[q[2]][q[3]]
		for(int i = query[0]; i < query[2]; i++) {
			swap = table[i][query[3] - 1];
			table[i][query[3] - 1] = next;
			next = swap;
			minimum = Math.min(minimum, next);
		}
		
		//table[q[2]][q[3]-1] -> table[q[2]][q[1]]
		for(int i = query[3] - 2; i >= query[1] - 1; i--) {
			swap = table[query[2] - 1][i];
			table[query[2] - 1][i] = next;
			next = swap;
			minimum = Math.min(minimum, next);
		}
		
		
		//table[q[2]-1][q[1]] -> table[q[0]][q[1]]
		for (int i = query[2] - 2; i >= query[0]; i--) {
			swap = table[i][query[1] - 1];
			table[i][query[1] - 1] = next;
			next = swap;
			
			minimum = Math.min(minimum, next);
		}
		
		table[query[0] - 1][query[1] - 1] = next;
		
		return minimum;
	}
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        table = new int[rows][columns];
        
        int cnt = 0;
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++) {
        		cnt++;
            	table[i][j] = cnt;            	
            }	
        }
        
        int i = 0;
        for(int[] query : queries) {
        	answer[i] = rotate(query);
        	i++;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		TableRotate tr = new TableRotate();
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int[] result = tr.solution(rows, columns, queries);
		for(int a : result) {
			System.out.println(a);	
		}
		
	}
}
