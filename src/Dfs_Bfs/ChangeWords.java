package Dfs_Bfs;

import java.util.Arrays;

public class ChangeWords {
	public static boolean stringCheck(String a, String b) {
		int cnt = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {				
				cnt++;
			}
			
			if(cnt > 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int answer;
	public static void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
		if(begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		
		for(int i = 0; i < words.length; i++) {
			if(!visited[i] && stringCheck(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, visited, cnt+1);
				visited[i] = false;
			}
		}
	}
	
    public int solution(String begin, String target, String[] words) {
    	int check = 0;
    	for(int i = 0; i < words.length; i++) {
    		if(target.equals(words[i])) {
    			check++;
    			break;
    		}
    	}
    	if(check == 0) {
    		return 0;
    	}
    	
    	boolean[] visited = new boolean[words.length];
    	Arrays.fill(visited, false);
    	
    	answer = Integer.MAX_VALUE;
    	
    	dfs(begin, target, words, visited, 0);        
    	
        return (answer == Integer.MAX_VALUE)? 0: answer;
    }
    
    public static void main(String[] args) {
		ChangeWords cw = new ChangeWords();
		
		System.out.println(cw.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
}
