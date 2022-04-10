package Graph;

import java.util.Arrays;

public class FindCount {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int maxFight = 101;	//100명이므로 최대 경기 수는 99이다.
        int[][] fight = new int[n+1][n+1];
        
        for(int[] f : fight) {
        	Arrays.fill(f, 101);
        }
        
        for(int i = 0; i < results.length; i ++) {
        	fight[results[i][0]][results[i][1]] = 1;
        }
        
        for(int k = 0; k < n+1; k++) {
        	for(int a = 0; a < n+1; a++) {
        		for(int b = 0; b < n+1; b++) {
        			if(fight[a][b] > fight[a][k] + fight[k][b]) {
        				fight[a][b] = fight[a][k] + fight[k][b];
        			}
        		}
        	}
        }
        
        
        for(int i = 0; i < n+1; i++) {
        	int cnt = 0;
        	for(int j = 0 ; j < n+1; j++) {
        		if(fight[i][j] < maxFight || fight[j][i] < maxFight) {
        			cnt++;
        		}
        	}
        	if(cnt == n - 1) {
        		answer++;
        	}
        }
        
        
        return answer;
    }
}
